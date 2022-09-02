import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer';
import {CustomerService} from '../../service/customer.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {HttpErrorResponse} from '@angular/common/http';
import {CustomerType} from '../../model/customerType';
import {CustomerTypeService} from '../../service/customer-type.service';
import {NotifierService} from 'angular-notifier';
import {ActivatedRoute} from '@angular/router';
import {ValidateUrl} from '../vadilator/url.validator';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customers: Customer[];
  deleteCustomer: Customer;
  formCreate: FormGroup;
  formEdit: FormGroup;
  customerTypeList: CustomerType[];
  customerTypeEdit: CustomerType = null;
  thePageNumber = 1;
  thePageSize = 5;
  theTotalElements: number;
  itemPerPage = 1;
  keywordForSearch: undefined;
  valueForFilter: 0;

  constructor(private customerService: CustomerService, private fb: FormBuilder, private customerTypeService: CustomerTypeService,
              private notifier: NotifierService, private routerActive: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.listCustomers();
    this.notifier.notify('success', 'Get list customer successfully');

    this.formCreate = this.fb.group(
      {
        name: ['', [Validators.required]],
        birthDay: [],
        idCard: [],
        phone: [],
        email: [],
        address: [],
        customerType: []
      }
    );
    this.formCreate.get('customerType').setValue('Default');
    this.customerTypeService.getAllCustomerType().subscribe(
      data => {
        this.customerTypeList = data;
      }
    );
    this.formEdit = this.fb.group(
      {
        id: [],
        name: [],
        birthDay: [],
        idCard: [],
        phone: [],
        email: [],
        address: [],
        customerType: []
      }
    );
  }

  listCustomers() {
    console.log('Key: ' + this.keywordForSearch);
    console.log('Value: ' + this.valueForFilter);
    if (this.keywordForSearch === undefined && this.valueForFilter === undefined) {
      this.customerService.getAllCustomer1(this.thePageNumber - 1, this.thePageSize).subscribe(this.processResult());
      console.log('Get All');
    } else {
      if (this.keywordForSearch !== undefined && this.valueForFilter !== undefined) {
        this.searchByNameAndCategory(this.keywordForSearch);
        console.log('Get By Name And Type');
      } else {
        if (this.keywordForSearch !== undefined && this.valueForFilter === undefined) {
          this.searchByName(this.keywordForSearch);
          console.log('Get By Name');
        } else {
          this.filterByCustomerType(this.valueForFilter);
          console.log('Get By Type');
        }
      }
    }
  }

  processResult() {
    return (data) => {
      this.customers = data.content; //
      this.thePageNumber = data.number + 1;
      this.thePageSize = data.size;
      this.theTotalElements = data.totalElements;
      this.processItemPerPage();
    };
  }

  processItemPerPage() {
    if (this.thePageNumber * this.thePageSize > this.theTotalElements) {
      this.itemPerPage = this.theTotalElements;
    } else {
      this.itemPerPage = this.thePageNumber * this.thePageSize;
    }
  }

  public onAddCustomer(addForm: FormGroup): void {
    // document.getElementById('add-customer-form').click();
    console.log(addForm.value);
    this.customerService.addCustomer(addForm.value).subscribe(
      (data: Customer) => {
        this.listCustomers();
        this.notifier.notify('success', 'Add customer successfully');
        addForm.reset();
        this.formCreate.get('customerType').setValue('Default');
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onUpdateCustomer(editForm: FormGroup): void {
    this.customerService.updateCustomer(editForm.value).subscribe(
      (data: Customer) => {
        console.log(editForm.value);
        this.listCustomers();
        this.notifier.notify('success', 'Edit customer successfully');
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteCustomer(customerId: number): void {
    this.customerService.deleteCustomer(customerId).subscribe(
      (data: void) => {
        console.log(data);
        this.listCustomers();
        this.notifier.notify('success', 'Delete customer successfully');
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(customer: Customer, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addCustomerModal');
    }
    if (mode === 'edit') {
      this.formEdit.controls.id.setValue(customer.id);
      this.formEdit.controls.name.setValue(customer.name, Validators.compose([
        Validators.required
      ]));
      this.formEdit.controls.birthDay.setValue(customer.birthDay);
      this.formEdit.controls.idCard.setValue(customer.idCard);
      this.formEdit.controls.phone.setValue(customer.phone);
      this.formEdit.controls.email.setValue(customer.email);
      this.formEdit.controls.address.setValue(customer.address);
      // this.formEdit.controls.customerType.setValue(customer.customerType);
      // this.customerTypeEdit = customer.customerType;
      this.formEdit.get('customerType').setValue('Default');
      console.log(customer.customerType);
      button.setAttribute('data-target', '#editCustomerModal');
    }
    if (mode === 'delete') {
      this.deleteCustomer = customer;
      button.setAttribute('data-target', '#deleteCustomerModal');
    }
    container.appendChild(button);
    button.click();
  }


  resetForm(formCreate: FormGroup) {
    formCreate.reset();
    this.formCreate.get('customerType').setValue('Default');
  }

  searchByName(value: string) {
    if (this.valueForFilter !== undefined) {
      this.searchByNameAndCategory(value);
    } else {
      this.customerService.getCustomerByName(this.thePageNumber - 1, this.thePageSize, value).subscribe(this.processResult());
    }
  }

  clearSearchKeyword() {
    this.keywordForSearch = undefined;
    this.listCustomers();
  }

  updatePageSize(pageSize) {
    this.thePageSize = pageSize;
    this.thePageNumber = 1;
    this.listCustomers();
  }

  setValueForFilter(value) {
    this.valueForFilter = value;
    this.listCustomers();
  }


  filterByCustomerType(value) {
    if (value === '0') {
         this.valueForFilter = undefined;
         this.listCustomers();
    } else {
      this.customerService.getCustomerByCustomerType(this.thePageNumber - 1, this.thePageSize, value).subscribe(this.processResult());
    }
  }
  searchByNameAndCategory(value: string) {
        if (value === '' && this.valueForFilter.toString() === '0') {
          this.valueForFilter = undefined;
          this.keywordForSearch = undefined;
          this.listCustomers();
        } else {
          if (value !== '' && this.valueForFilter.toString() === '0') {
            this.valueForFilter = undefined;
            this.listCustomers();
          } else {
            this.customerService.getCustomerByNameAndCustomerType(this.thePageNumber - 1, this.thePageSize, this.valueForFilter, value)
              .subscribe(this.processResult());
          }
        }
    }
}
