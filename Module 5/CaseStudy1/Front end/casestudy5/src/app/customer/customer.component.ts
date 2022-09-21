import {Component, OnInit} from '@angular/core';
import {Item} from '../../model/Item';
import {CustomerService} from '../../service/customer.service';
import { FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {HttpErrorResponse} from '@angular/common/http';
import {Product} from '../../model/product';
import {CustomerTypeService} from '../../service/customer-type.service';




@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  items: Item[];
  deleteCustomer: Item;
  formCreate: FormGroup;
 productList: Product[];
  thePageNumber = 1;
  thePageSize = 5;
  theTotalElements: number;
  itemPerPage = 1;
  keywordForSearch: undefined;



  constructor(private customerService: CustomerService, private fb: FormBuilder, private customerTypeService: CustomerTypeService,
              ) {
  }

  ngOnInit(): void {
    this.listCustomers();

    this.formCreate = this.fb.group(
      {
        code: ['', [Validators.required, Validators.pattern('^LH-[0-9]{4}$')]],
        quantity: ['', [Validators.required, Validators.pattern('^[0-9]{5}$')]],
        // tslint:disable-next-line:max-line-length
        nhap: ['', [Validators.required, Validators.pattern('^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(?:(?:(|-|)(?:0?[13578]|1[02])\\1(?:31))|(?:(|-|)' + '(?:0?[13-9]|1[0-2])\\2(?:29|30)))$|^(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(|-|)0?2\\3(?:29)$|^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(|-|)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:0?[1-9]|1\\d|2[0-8])$')]],
        // tslint:disable-next-line:max-line-length
        xuat: ['', [Validators.required, Validators.pattern('^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(?:(?:(|-|)(?:0?[13578]|1[02])\\1(?:31))|(?:(|-|)' + '(?:0?[13-9]|1[0-2])\\2(?:29|30)))$|^(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(|-|)0?2\\3(?:29)$|^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(|-|)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:0?[1-9]|1\\d|2[0-8])$')]],
        // tslint:disable-next-line:max-line-length
        han: ['', [Validators.required, Validators.pattern('^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(?:(?:(|-|)(?:0?[13578]|1[02])\\1(?:31))|(?:(|-|)' + '(?:0?[13-9]|1[0-2])\\2(?:29|30)))$|^(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(|-|)0?2\\3(?:29)$|^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(|-|)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:0?[1-9]|1\\d|2[0-8])$')]],
        product: []
      }
    );
    this.customerTypeService.getAllCustomerType().subscribe(
      data => {
        this.productList = data;
      }
    );
    // this.formEdit = this.fb.group(
    //   {
    //     id: [],
    //     name: [],
    //     birthDay: [],
    //     idCard: [],
    //     phone: [],
    //     email: [],
    //     address: [],
    //     customerType: []
    //   }
    // );
  }

  listCustomers() {
    if (this.keywordForSearch === undefined) {
      this.customerService.getAllCustomer1(this.thePageNumber - 1, this.thePageSize).subscribe(this.processResult());
    } else {
      this.searchByName(this.keywordForSearch);
    }
  }

  listCustomers2() {
      this.customerService.getAllCustomer1(this.thePageNumber - 1, this.thePageSize).subscribe(this.processResult());
  }
  processResult() {
    return (data) => {
      this.items = data.content; //
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
    this.customerService.addCustomer(addForm.value).subscribe(
      (data: Item) => {
        this.listCustomers2();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
      }
    );
  }

  public onDeleteCustomer(customerId: number): void {
    this.customerService.deleteCustomer(customerId).subscribe(
      (data: void) => {
        this.listCustomers2();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(customer: Item, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addCustomerModal');
    }
    // if (mode === 'edit') {
    //   this.formEdit.controls.id.setValue(customer.id);
    //   this.formEdit.controls.name.setValue(customer.name, Validators.compose([
    //     Validators.required
    //   ]));
    //   this.formEdit.controls.birthDay.setValue(customer.birthDay);
    //   this.formEdit.controls.idCard.setValue(customer.idCard);
    //   this.formEdit.controls.phone.setValue(customer.phone);
    //   this.formEdit.controls.email.setValue(customer.email);
    //   this.formEdit.controls.address.setValue(customer.address);
    //   this.formEdit.get('customerType').setValue(customer.customerType);
    //   console.log(customer.customerType);
    //   button.setAttribute('data-target', '#editCustomerModal');
    // }
    if (mode === 'delete') {
      this.deleteCustomer = customer;
      button.setAttribute('data-target', '#deleteCustomerModal');
    }
    container.appendChild(button);
    button.click();
  }



  // resetForm() {
  //   this.checkValidate = true;
  //   this.formCreate = this.fb.group(
  //     {
  //       // tslint:disable-next-line:max-line-length
  // tslint:disable-next-line:max-line-length
  //       name: ['', Validators.pattern('^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(?:(?:(|-|)(?:0?[13578]|1[02])\\1(?:31))|(?:(|-|)' + '(?:0?[13-9]|1[0-2])\\2(?:29|30)))$|^(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(|-|)0?2\\3(?:29)$|^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(|-|)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:0?[1-9]|1\\d|2[0-8])$')],
  //       date: new FormGroup({
  //         birthDay: new FormControl(),
  //         endDay: new FormControl(),
  //       }, checkDay),
  //       idCard: [''],
  //       phone: [''],
  //       email: [''],
  //       address: [''],
  //       customerType: []
  //     }
  //   );
  //   console.log(1);
  // }
  searchByName(value: string) {
    value = value.trim();
    this.customerService.getCustomerByName(this.thePageNumber - 1, this.thePageSize, value).subscribe(this.processResult());
  }

  // clearSearchKeyword() {
  //   this.keywordForSearch = undefined;
  //   this.listCustomers();
  // }

  updatePageSize(pageSize) {
    this.thePageSize = pageSize;
    this.thePageNumber = 1;
    this.listCustomers();
  }

  // setValueForFilter(value) {
  //   this.valueForFilter = value;
  //   this.listCustomers();
  // }
  //
  //
  // filterByCustomerType(value) {
  //   if (value === '0') {
  //     this.valueForFilter = undefined;
  //     this.listCustomers();
  //   } else {
  //     this.customerService.getCustomerByCustomerType(this.thePageNumber - 1, this.thePageSize, value).subscribe(this.processResult());
  //   }
  // }
  //
  // searchByNameAndCategory(value: string) {
  //   if (value === '' && this.valueForFilter.toString() === '0') {
  //     this.valueForFilter = undefined;
  //     this.keywordForSearch = undefined;
  //     this.listCustomers();
  //   } else {
  //     if (value !== '' && this.valueForFilter.toString() === '0') {
  //       this.valueForFilter = undefined;
  //       this.listCustomers();
  //     } else {
  //       this.customerService.getCustomerByNameAndCustomerType(this.thePageNumber - 1, this.thePageSize, this.valueForFilter, value)
  //         .subscribe(this.processResult());
  //     }
  //   }
  // }


}
