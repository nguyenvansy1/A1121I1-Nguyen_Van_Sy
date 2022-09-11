import { Component, OnInit } from '@angular/core';
import {ProductService} from '../service/product.service';
import {Product} from '../model/product';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  constructor(private productService: ProductService) { }
  products: Product[] = [];
  message: string;
  // products: Product[] = [];
  // message: string;
  // constructor(private productService: ProductService) { }
  //
  // ngOnInit(): void {
  //  this.getAllList();
  // }

  ngOnInit(): void {
    this.productService.getAll().subscribe(
      (data) => {
        this.products = data;
      }
    );
  }
}
