import { Injectable } from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  // products: Product[] = [{
  //   id: 1,
  //   name: 'IPhone 12',
  //   price: 2400000,
  //   description: 'New'
  // }, {
  //   id: 2,
  //   name: 'IPhone 11',
  //   price: 1560000,
  //   description: 'Like new'
  // }, {
  //   id: 3,
  //   name: 'IPhone X',
  //   price: 968000,
  //   description: '97%'
  // }, {
  //   id: 4,
  //   name: 'IPhone 8',
  //   price: 7540000,
  //   description: '98%'
  // }, {
  //   id: 5,
  //   name: 'IPhone 11 Pro',
  //   price: 1895000,
  //   description: 'Like new'
  // }];
  // constructor() { }
  // getAll(){
  //   return this.products;
  // }
  // saveProduct(product: Product) {
  //   let check = true;
  //   let j: number;
  //   for (let i = 0; i < this.products.length; i++) {
  //     if (this.products[i].id === product.id) {
  //       check = false;
  //       j = i;
  //       break;
  //     }
  //   }
  //   if (check) {
  //     this.products.push(product);
  //   } else {
  //     this.products[j] = product;
  //   }
  // }
  // // @ts-ignore
  // findById(id: number): Product {
  //   return this.products.find((product) => product.id === id);
  // }
  // updateProduct(id: number, product: Product){
  //   // tslint:disable-next-line:prefer-for-of
  //  for (let i = 0; i < this.products.length; i++){
  //    if (this.products[i].id === id) {
  //      this.products[i] = product;
  //    }
  //  }
  // }
  // // deleteProduct(id: number){
  // //   for (let i = 0; i <= this.products.length; i++) {
  // //     if (this.products[i].id === id) {
  // //       this.pr
  // //     }
  // //   }
  // // }
  // deleteProduct(id: number) {
  //   this.products = this.products.filter(product => {
  //     return product.id !== id;
  //   });
  // }

  URL_API = 'http://localhost:3000/products';
  products: Product[]  | undefined;
  constructor(private httpClient: HttpClient) { }
  getAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.URL_API);
  }
  saveProduct(product: Product): Observable<any> {
    return this.httpClient.post(this.URL_API, product);
  }
  // @ts-ignore
  /* findById(id: number): Product {
     return this.products.find((product) => product.id === id);
   }*/
  findById(id: number): Observable<Product> {
    return this.httpClient.get(this.URL_API + '/' + id);
  }
  /*updateProduct(id: number, product: Product){
    // tslint:disable-next-line:prefer-for-of
   for (let i = 0; i < this.products.length; i++){
     if (this.products[i].id === id) {
       this.products[i] = product;
     }
   }
  }*/
  updateProduct(id: number, product: Product): Observable<Product>{
    return this.httpClient.put(this.URL_API + '/' + id, product);
  }
  // deleteProduct(id: number){
  //   for (let i = 0; i <= this.products.length; i++) {
  //     if (this.products[i].id === id) {
  //       this.pr
  //     }
  //   }
  // }
  deleteProduct(id: number) {
    return this.httpClient.delete(this.URL_API + '/' + id);
  }
  /*deleteProduct(id: number) {
    this.products = this.products.filter(product => {
      return product.id !== id;
    });
  }*/
}
