import { Injectable } from '@angular/core';
import {Dictionary} from "../model/dictionary";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {

  constructor() { }
  dictionaries: Dictionary[] = [{
    id: 1,
    word: 'Flower',
    mean: 'Bông Hoa'
  },{
    id: 2,
    word: 'Beautiful',
    mean: 'Xinh Đẹp'
  },{
    id: 3,
    word: 'Good luck',
    mean: 'Chúc may mắn'
  },{
    id: 4,
    word: 'Have a nice day',
    mean: 'Chúc một ngày tốt lành'
  }];

  getAll() {
    return this.dictionaries;
  }

  findById(number: number) {
    for(let dictionary of this.dictionaries) {
      if(dictionary.id == number) {
        return dictionary
      }
    }
  }
}
