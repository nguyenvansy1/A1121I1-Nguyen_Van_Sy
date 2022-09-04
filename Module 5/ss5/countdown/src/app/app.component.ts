import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'countdown';
  @Input()
  seconds = 11;
  @Output()
  finish = new EventEmitter<boolean>();
  remainingTime: number;
  private intervalId = 0;
  message = '';

  constructor() {
  }

  clearTimer() {
    clearInterval(this.intervalId);
  }

  ngOnInit(): void {
    this.reset();
  }

  private countDown() {
    // this.clearTimer();
    this.intervalId = window.setInterval(() => {
      this.remainingTime -= 1;
      if (this.remainingTime === 0) {
        this.clearTimer();
        this.finish.emit(true);
      }
    }, 1000);
  }

  start() {
    this.message = '';
    this.countDown();
    if (this.remainingTime <= 0) {
      this.remainingTime = this.seconds;
    }
  }

  reset() {
    this.clearTimer();
    this.message = `Holding at T-${this.remainingTime} seconds`;
  }

  stop() {
    this.clearTimer();
    this.remainingTime = this.seconds;
    this.message = 'Click start button to start the Countdown';
    this.finish.emit(false);

  }
}
