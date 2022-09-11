import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Student} from "../../../model/student";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {StudentService} from "../../../service/student.service";

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit, OnChanges {
   student: Student;

  constructor(private activatedRoute: ActivatedRoute, private studentService: StudentService) {
    activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      const name = paramMap.get('name');
      console.log(name)
      this.student = this.studentService.findById(parseInt(id));
    })
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log("0")
  }

  @Input("studentList") students;

  ngOnInit(): void {
    console.log(this.students);
  }

  // changeNameStudent(value: string) {
  //   this.student.nameStudent = value;
  // }
}
