import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer';
import {CustomerService} from '../../service/customer.service';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {HttpErrorResponse} from '@angular/common/http';
import {CustomerType} from '../../model/customerType';
import {CustomerTypeService} from '../../service/customer-type.service';
import {NotifierService} from 'angular-notifier';
import {ActivatedRoute} from '@angular/router';
import {checkDay, ValidateName} from '../vadilator/custom.validator';
import {formatDate} from '@angular/common';


@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customers: Customer[];
  deleteCustomer: Customer;
  customerErr: Customer;
  formCreate: FormGroup;
  formEdit: FormGroup;
  customerTypeList: CustomerType[];
  thePageNumber = 1;
  thePageSize = 5;
  theTotalElements: number;
  itemPerPage = 1;
  keywordForSearch: undefined;
  valueForFilter: 0;
  checkValidate = false;


  constructor(private customerService: CustomerService, private fb: FormBuilder, private customerTypeService: CustomerTypeService,
              private notifier: NotifierService, private routerActive: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.listCustomers();
    this.notifier.notify('success', 'Get list customer successfully');

    // this.formCreate = this.fb.group(
    //   {
    //     name: [''],
    //     // tslint:disable-next-line:max-line-length
    // tslint:disable-next-line:max-line-length
    //     birthDay: ['', Validators.pattern('^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(?:(?:(|-|)(?:0?[13578]|1[02])\\1(?:31))|(?:(|-|)' + '(?:0?[13-9]|1[0-2])\\2(?:29|30)))$|^(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(|-|)0?2\\3(?:29)$|^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(|-|)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:0?[1-9]|1\\d|2[0-8])$')],
    //     endDay: [''],
    //     idCard: [''],
    //     phone: [''],
    //     email: [''],
    //     address: [''],
    //     customerType: []
    //   }
    // );


    // this.formCreate = new FormGroup(
    //   {
    //     name: new FormControl(),
    //     // tslint:disable-next-line:max-line-length
    // tslint:disable-next-line:max-line-length
    //     birthDay: new FormControl('', Validators.pattern('^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(?:(?:(|-|)(?:0?[13578]|1[02])\\1(?:31))|(?:(|-|)' + '(?:0?[13-9]|1[0-2])\\2(?:29|30)))$|^(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(|-|)0?2\\3(?:29)$|^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(|-|)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:0?[1-9]|1\\d|2[0-8])$')),
    //     endDay: new FormControl(),
    //     idCard: new FormControl(),
    //     phone: new FormControl(),
    //     email: new FormControl(),
    //     address: new FormControl(),
    //     customerType: new FormControl(),
    //   }, checkDay
    // );
    // this.formCreate = this.fb.group(
    //   {
    //     name: [''],
    //     date: new FormGroup({
    //       // tslint:disable-next-line:max-line-length
    //       birthDay: new FormControl(),
    //       endDay: new FormControl(),
    //     }, {validators: checkDay}),
    //     idCard: [''],
    //     phone: [''],
    //     email: [''],
    //     address: [''],
    //     customerType: []
    //   }
    // );
    this.formCreate = this.fb.group(
      {
        // tslint:disable-next-line:max-line-length
        name: ['', Validators.pattern('^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(?:(?:(|-|)(?:0?[13578]|1[02])\\1(?:31))|(?:(|-|)' + '(?:0?[13-9]|1[0-2])\\2(?:29|30)))$|^(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(|-|)0?2\\3(?:29)$|^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(|-|)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:0?[1-9]|1\\d|2[0-8])$')],
        date: new FormGroup({
          // tslint:disable-next-line:max-line-length
          // birthDay: new FormControl('', Validators.pattern('^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(?:(?:(|-|)(?:0?[13578]|1[02])\\1(?:31))|(?:(|-|)' + '(?:0?[13-9]|1[0-2])\\2(?:29|30)))$|^(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(|-|)0?2\\3(?:29)$|^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(|-|)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:0?[1-9]|1\\d|2[0-8])$')),
          birthDay: new FormControl(),
          endDay: new FormControl(),
        }, checkDay),
        idCard: [''],
        phone: [''],
        email: [''],
        address: [''],
        customerType: []
      }
    );
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
    this.checkValidate = false;
    // document.getElementById('add-customer-form').click();
    console.log(addForm.value);
    this.customerService.addCustomer(addForm.value).subscribe(
      (data: Customer) => {
        this.listCustomers();
        this.notifier.notify('success', 'Add customer successfully');
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        console.log(error);
        this.customerErr = error.error;
      }
    );
  }

  public onUpdateCustomer(editForm: FormGroup): void {
    if (editForm.value.customerType === 'Default') {
      this.formEdit.controls.customerType.setValue(null);
    }
    this.customerService.updateCustomer(editForm.value).subscribe(
      (data: Customer) => {
        this.formEdit.get('customerType').setValue('Default');
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
      this.formEdit.get('customerType').setValue(customer.customerType);
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

  compareFn(c1: CustomerType, c2: CustomerType): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  resetForm() {
    // event.currentTarget.reset();
    this.checkValidate = true;
    // this.formCreate = this.fb.group(
    //   {
    //     name: [''],
    //     date: new FormGroup({
    //       birthDay: new FormControl(),
    //       endDay: new FormControl(),
    //       // tslint:disable-next-line:max-line-length
    // tslint:disable-next-line:max-line-length
    //     }, Validators.compose([checkDay, Validators.required, Validators.pattern('^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(?:(?:(|-|)(?:0?[13578]|1[02])\\1(?:31))|(?:(|-|)' + '(?:0?[13-9]|1[0-2])\\2(?:29|30)))$|^(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(|-|)0?2\\3(?:29)$|^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(|-|)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:0?[1-9]|1\\d|2[0-8])$')])),
    //     idCard: [''],
    //     phone: [''],
    //     email: [''],
    //     address: [''],
    //     customerType: []
    //   }
    // );
    console.log(1);
  }
  searchByName(value: string) {
    value = value.trim();
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

  // this.formCreate = new FormGroup({
  //
  //   startDate : new FormControl( this.date1, [Validators.required]),
  //   endDate :   new FormControl( this.date1, [Validators.required]),
  //   deposit : new FormControl("", [Validators.required, Validators.minLength(2)]),
  //   totalMoney : new FormControl("", [Validators.required, Validators.min(5), Validators.max(10)]),
  //   employee : new FormControl("", [Validators.required, Validators.minLength(5)]),
  //   customer : new FormControl("", [Validators.required]),
  //   service : new FormControl("", [Validators.required]),
  // }, identityRevealedValidator );

// <div  *ngIf="formCreate.hasError('dateError')" class="alert alert-danger" role="alert">
//     Ngay bat dau phai truoc ngay ket thuc
//   </div>
}
