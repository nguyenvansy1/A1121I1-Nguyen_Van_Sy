import {Component, EventEmitter, OnInit, Output} from '@angular/core';

class IRatingUnit {
  static rating: IRatingUnit[] = [
    {value: 1, action: 0},
    {value: 2, action: 0},
    {value: 3, action: 0},
    {value: 4, action: 0},
    {value: 5, action: 0},
    {value: 6, action: 0},
    {value: 7, action: 0},
    {value: 8, action: 0},
    {value: 9, action: 0},
    {value: 10, action: 0}
  ];
  value: number;
  action: number;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'vote';
  @Output()
  ratingEvent = new EventEmitter<number>();
  rating: IRatingUnit[] = IRatingUnit.rating;

  constructor() { }

  ngOnInit(): void {
  }


  getData(value: number) {
    this.ratingEvent.emit(value);
    for (let i = 0;  i < value; i++) {
      this.rating[i].action = 1;
    }
  }
}
