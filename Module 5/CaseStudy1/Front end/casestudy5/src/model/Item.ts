import {Product} from './product';

export interface Item {
  id?: number;
  code?: string;
  quantity?: number;
  nhap?: string;
  xuat?: string;
  han?: string;
  product?: Product;
}
