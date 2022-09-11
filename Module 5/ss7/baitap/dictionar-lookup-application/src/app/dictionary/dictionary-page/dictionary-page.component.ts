import { Component, OnInit } from '@angular/core';
import {DictionaryService} from "../../service/dictionary.service";
import {FormControl, FormGroup} from "@angular/forms";
import {Dictionary} from "../../model/dictionary";

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {

  dictionaries: Dictionary[] = [];

  // dictionaryForm : FormGroup = new FormGroup({
  //   word: new FormControl(),
  //   mean: new FormControl()
  // })

  constructor(private dictionaryService: DictionaryService) { }

  ngOnInit(): void {
    this.getAll()
  }

  getAll() {
    this.dictionaries = this.dictionaryService.getAll();
  }
}
