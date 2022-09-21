import {AbstractControl, ValidationErrors} from '@angular/forms';
import {formatDate} from '@angular/common';

export function ValidateName(control: AbstractControl) {
  if (!control.value.startsWith('Nguyen')) {
    return { invalidName: true };
  }
  return null;
}

// export function checkDay( c: AbstractControl) {
//   const v = c.value;
//   const  str1 = v.birthDay.substr(0, 4);
//   const  str2 = v.endDay.substr(0, 4);
//
//   return str1.length === 4 ? null : {checkDayErr: true};
// }
//
// export function CheckDay1( control: AbstractControl) {
//   // tslint:disable-next-line:max-line-length
//   const regexPhoneNumber = /(84|0[3|5|7|8|9])+([0-9]{8})\b/g;
//
//   return control.value.address.match(regexPhoneNumber) ? null : {checkDayErr: true};
//   }

// export function checkDay(control: AbstractControl): ValidationErrors|null {
//   const start = control.value.birthDay ;
//   const end =  control.value.endDay;
//   const day1 = formatDate(start, 'yyyy-MM-dd', 'en_US');
//   const day2  = formatDate(end, 'yyyy-MM-dd', 'en_US');
//   return day1 <= day2 ? null : {checkDayErr: true};
// }

// export function checkDay(control: AbstractControl): ValidationErrors|null {
//   const startDate: string = control.value.birthDay ;
//   const endDate: string =  control.value.endDay;
//   // tslint:disable-next-line:radix
//   return parseInt(startDate.substring(2, 4)) === parseInt(endDate) ? null : {checkDayErr: true};
// }
