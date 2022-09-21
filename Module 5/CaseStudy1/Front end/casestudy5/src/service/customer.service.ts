import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Item} from '../model/Item';



@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private URL_API = 'http://localhost:8080/api/customer';

  constructor(private httpClient: HttpClient) {
  }

  getAllCustomer(): Observable<Item[]> {
    return this.httpClient.get<Item[]>(`${this.URL_API}/list`);
  }

  getAllCustomer1(thePage: number, thePageSize: number): Observable<GetResponseCustomers> {
    const url = `${this.URL_API}/all?` + `&page=${thePage}&size=${thePageSize}`;
    return this.httpClient.get<GetResponseCustomers>(url);
  }

  addCustomer(customer: Item): Observable<Item> {
    return this.httpClient.post<Item>(`${this.URL_API}/add`, customer);
  }
  //
  deleteCustomer(customerId: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.URL_API}/delete/${customerId}`);
  }
  //
  //  updateCustomer(customer: Item): Observable<Item> {
  //   return this.httpClient.patch<Item>(`${this.URL_API}/update`, customer);
  // }
  //
  getCustomerByName(thePage: number, thePageSize: number, name: string): Observable<GetResponseCustomers> {
    const url = `${this.URL_API}/search?` + `name=${name}&page=${thePage}&size=${thePageSize}`;
    return this.httpClient.get<GetResponseCustomers>(url);
  }
  //
  // getCustomerByCustomerType(thePage: number, thePageSize: number, id: number): Observable<GetResponseCustomers> {
  //   const url = `${this.URL_API}/filter?` + `id=${id}&page=${thePage}&size=${thePageSize}`;
  //   return this.httpClient.get<GetResponseCustomers>(url);
  // }
  //
  // getCustomerByNameAndCustomerType(thePage: number, thePageSize: number , id: number , name: string ): Observable<GetResponseCustomers> {
  //   const url = `${this.URL_API}/filter-customerType-name?` + `id=${id}&name=${name}&page=${thePage}&size=${thePageSize}`;
  //   return this.httpClient.get<GetResponseCustomers>(url);
  // }
}

interface GetResponseCustomers {
  content: Item[];
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
}
