import { Component, OnInit } from '@angular/core';
import {CustomerTypeService} from '../../service/customer-type.service';
import {Product} from '../../model/product';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor() { }

  ngOnInit(): void {
  }

}
