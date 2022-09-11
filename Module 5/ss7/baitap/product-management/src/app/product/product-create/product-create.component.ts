// import { Component, OnInit } from '@angular/core';
// import {ProductService} from "../../service/product.service";
// import {FormControl, FormGroup} from "@angular/forms";
//
// @Component({
//   selector: 'app-product-create',
//   templateUrl: './product-create.component.html',
//   styleUrls: ['./product-create.component.css']
// })
// export class ProductCreateComponent implements OnInit {
//
//   productForm: FormGroup = new FormGroup({
//     id: new FormControl(),
//     name: new FormControl(),
//     price: new FormControl(),
//     description: new FormControl(),
//   });
//
//   constructor(private productService: ProductService) { }
//
//   ngOnInit(): void {
//   }
//
//   submit() {
//     const product = this.productForm.value;
//     this.productService.saveProduct(product);
//     this.productForm.reset();
//   }
// }
import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup = new FormGroup({
    id: new FormControl('', [Validators.required]),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
  });
  get id(){
    return this.productForm.get('id');
  }

  constructor(private productService: ProductService , private router: Router) {
  }

  ngOnInit() {
  }

  submit() {
    const product = this.productForm.value;
    this.productService.saveProduct(product);
    this.router.navigateByUrl('product/list');
  }
}
