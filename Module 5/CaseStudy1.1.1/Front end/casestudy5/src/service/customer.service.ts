import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer';



@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private URL_API = 'http://localhost:8080/api/customer';

  constructor(private httpClient: HttpClient) {
  }

  getAllCustomer(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(`${this.URL_API}/list`);
  }

  getAllCustomer1(thePage: number, thePageSize: number): Observable<GetResponseCustomers> {
    const url = `${this.URL_API}/all?` + `&page=${thePage}&size=${thePageSize}`;
    return this.httpClient.get<GetResponseCustomers>(url);
  }

  addCustomer(customer: Customer): Observable<Customer> {
    return this.httpClient.post<Customer>(`${this.URL_API}/add`, customer);
  }

  deleteCustomer(customerId: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.URL_API}/delete/${customerId}`);
  }

   updateCustomer(customer: Customer): Observable<Customer> {
    return this.httpClient.patch<Customer>(`${this.URL_API}/update`, customer);
  }

  getCustomerByName(thePage: number, thePageSize: number, name: string): Observable<GetResponseCustomers> {
    const url = `${this.URL_API}/search?` + `name=${name}&page=${thePage}&size=${thePageSize}`;
    return this.httpClient.get<GetResponseCustomers>(url);
  }

  getCustomerByCustomerType(thePage: number, thePageSize: number, id: number): Observable<GetResponseCustomers> {
    const url = `${this.URL_API}/filter?` + `id=${id}&page=${thePage}&size=${thePageSize}`;
    return this.httpClient.get<GetResponseCustomers>(url);
  }

  getCustomerByNameAndCustomerType(thePage: number, thePageSize: number , id: number , name: string ): Observable<GetResponseCustomers> {
    const url = `${this.URL_API}/filter-customerType-name?` + `id=${id}&name=${name}&page=${thePage}&size=${thePageSize}`;
    return this.httpClient.get<GetResponseCustomers>(url);
  }
}

interface GetResponseCustomers {
  content: Customer[];
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
}
