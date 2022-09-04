import { AbstractControl } from '@angular/forms';

export function ValidateName(control: AbstractControl) {
  if (!control.value.startsWith('Nguyen')) {
    return { invalidName: true };
  }
  return null;
}

