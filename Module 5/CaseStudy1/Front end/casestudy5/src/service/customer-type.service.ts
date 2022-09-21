import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Item} from '../model/Item';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  private URL_API = 'http://localhost:8080/api/customer';

  constructor(private  httpClient: HttpClient) {
  }

  getAllCustomerType(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${this.URL_API}/type`);
  }

}
