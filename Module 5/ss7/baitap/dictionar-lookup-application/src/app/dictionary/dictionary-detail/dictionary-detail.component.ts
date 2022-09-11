import { Component, OnInit } from '@angular/core';
import {DictionaryService} from "../../service/dictionary.service";
import {Dictionary} from "../../model/dictionary";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {

  dictionary: Dictionary

  constructor(private activatedRoute: ActivatedRoute,  private dictionaryService: DictionaryService) {
    activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      const name = paramMap.get('name');
      console.log(name)
      this.dictionary = this.dictionaryService.findById(parseInt(id));
    })
  }

  ngOnInit(): void {
  }

}
