import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer';
import {CustomerType} from '../model/customerType';

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  private URL_API = 'http://localhost:8080/api/customer';

  constructor(private  httpClient: HttpClient) {
  }

  getAllCustomerType(): Observable<CustomerType[]> {
    return this.httpClient.get<CustomerType[]>(`${this.URL_API}/type`);
  }

}
