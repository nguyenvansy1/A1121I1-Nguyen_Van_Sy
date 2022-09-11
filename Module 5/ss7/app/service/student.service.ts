import { Injectable } from '@angular/core';
import {Student} from "../model/student";

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  students: Student[] = [];
  constructor() {
    this.students.push(new Student(1, "HaiTT", "1998-01-01", 9));
    this.students.push(new Student(2, "TrungDP", "1987-01-01", 10));
    this.students.push(new Student(3, "TrungDC", "1993-01-01", 8));
    this.students.push(new Student(4, "ChanhTV", "1986-01-01", 8));
  }
  getAll() {
    return this.students;
  }

  addStudent(event: Student) {
    this.students.push(event)
  }

  findById(number: number) {
    for(let student of this.students) {
      if(student.id == number) {
        return student
      }
    }
  }
}
