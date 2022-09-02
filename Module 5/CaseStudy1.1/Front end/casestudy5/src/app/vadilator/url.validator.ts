import { AbstractControl } from '@angular/forms';

export function ValidateUrl(control: AbstractControl) {
  if (!control.value.startsWith('nguyen') || !control.value.includes('sy')) {
    return { invalidUrl: true };
  }
  return null;
}
