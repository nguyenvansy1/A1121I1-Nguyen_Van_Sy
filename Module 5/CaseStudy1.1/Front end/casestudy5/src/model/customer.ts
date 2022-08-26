import {CustomerType} from './customerType';

export interface Customer {
  id?: number;
  name?: string;
  birthDay?: string;
  idCard?: number;
  phone?: string;
  email?: string;
  address?: string;
  customerType?: CustomerType;
}
