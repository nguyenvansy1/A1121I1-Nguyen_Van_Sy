use quan_li_sinh_vien;

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

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select * from student
where student_name like 'h%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select * from class
where month(start_date) = 12;


-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * from subject1 
where credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.

update class 
left join student on student.class_id = class.class_id
set class_name = 2
where student.student_name like 'Hung';

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.

