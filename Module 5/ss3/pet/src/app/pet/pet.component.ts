import { Component, OnInit } from '@angular/core';
import {IPet} from '../../model/IPet';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {

  pet: IPet = {
    name: 'puppie',
    image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTaH7hfaE2BpY43MajN8yohf24AWNkkpvRO1g&usqp=CAU'
  };
  constructor() { }

  ngOnInit(): void {
  }

}
