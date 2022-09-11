import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Student} from "../../../model/student";
import {StudentService} from "../../../service/student.service";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students: Student[] = []
  temp;

  constructor(private studentService: StudentService) {
    this.students = studentService.getAll();
  }


  ngOnInit(): void {
    console.log("1")
  }

}
