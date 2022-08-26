import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-caculator',
  templateUrl: './caculator.component.html',
  styleUrls: ['./caculator.component.css']
})
export class CaculatorComponent implements OnInit {
  result: number ;
  number1: number ;
  number2: number ;
  constructor() { }

  ngOnInit(): void {
  }
  calculate(num1: string, num2: string, cal: string) {
    this.result = 0;
    this.number1 = parseInt(num1);
    this.number2 = parseInt(num2);

    if (num1 == "" || num2 == "") {
      this.result = 0;
    } else {
      switch (cal) {
        case '+': {
          this.result = this.number1 + this.number2;
          break;
        }
        case '-': {
          this.result = this.number1 - this.number2;
          break;
        }
        case '*': {
          this.result = this.number1 * this.number2;
          break;
        }
        case '/': {
          this.result = this.number1 / this.number2;
          break;
        }
      }
    }
  }
}
