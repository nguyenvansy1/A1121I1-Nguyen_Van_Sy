use ss4_thao_tac_ham_csdl;

create table class(
 class_id int primary key,
 class_name varchar(50),
 start_date date,
 `status` int 
);


create table student(
 student_id int primary key,
 student_name varchar(50),
 address varchar(50),
 phone varchar(50),
 `status` int ,
 class_id int,
 FOREIGN KEY (class_id) REFERENCES class(class_id)
);


create table subject1(
 sub_id int primary key,
 sub_name varchar(50),
 credit int, 
 `status` int 
);

create table mark(
 mark_id int primary key,
 sub_id int ,
 student_id int,
 mark int ,
 exam_time int,
 FOREIGN KEY (sub_id) REFERENCES subject1(sub_id),
 FOREIGN KEY (student_id) REFERENCES student(student_id)
);

INSERT INTO class
VALUES (3, 'B3', current_date, 0);

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.

select *, max(credit) as max_credit  from subject1 ;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.

select *, max(mark) from subject1
join mark on mark.sub_id = subject1.sub_id;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select * ,avg(mark) from student
join mark on mark.student_id = student.student_id
group by mark.student_id
order by mark.mark asc

