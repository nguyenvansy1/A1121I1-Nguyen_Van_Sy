create database furama;
use furama;
create table `position`(
	position_id int primary key auto_increment,
    position_name varchar(45)
);

create table division(
	division_id int primary key auto_increment,
    division_name varchar(45)
);

create table education_degree(
	education_degree_id int primary key auto_increment,
    education_degree_name varchar(45)
);

create table role(
	role_id int primary key auto_increment,
    role_name varchar(255)
);


INSERT INTO customer(customer_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, 
customer_address,customer_type_id) VALUES('2', 'Nguyen Van Sy', '2021-12-12', b'0', '123123123', '+84-373216810', 'sypro123@gmail.com', 'Da Nang', '1');
create table employee(
	employee_id int primary key auto_increment,
    employee_name varchar(45) not null,
	employee_birthday date not null,
	employee_id_card varchar(45) not null,
	employee_salary double not null,
	employee_phone varchar(45) not null,
	employee_email varchar(45),
	employee_address varchar(45),
    position_id int not null,
    education_degree_id int not null,
    division_id int not null,
	user_id  int,
    foreign key(division_id) references division(division_id),
    foreign key(education_degree_id) references education_degree(education_degree_id),
    foreign key(position_id) references `position`(position_id),
    foreign key(user_id) references account1(user_id)
);

insert into employee(employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,
position_id,education_degree_id,division_id) values ('Nguyen Van Sy','2001-12-12','123123123','1245','+84-373216810','ss2s2@gmail.com','Da Nang','3','2','1');


INSERT INTO employee(`employee_id`, `employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`, `employee_phone`, `employee_email`,
 `employee_address`, `position_id`, `education_degree_id`, `division_id`) VALUES ('87', 'Nguyen Van Sy', '2001-12-12', '112312312', '2000', '+84-373216810', 
 'synguy12w31en@gmail.com', 'Da Nang', '2', '3', '3');
create table customer_type(
	customer_type_id int primary key auto_increment,
    customer_type_name varchar(45)
);

create table customer(
	customer_id int primary key auto_increment,
    customer_name varchar(45) not null,
    customer_birthday date not null,
    customer_gender bit(1) not null,
    customer_id_card varchar(45) not null,
    customer_phone varchar(45) not null,
    customer_email varchar(45),
    customer_address varchar(45),
    customer_type_id int not null,
    foreign key(customer_type_id) references customer_type(customer_type_id)
);

create table service_type(
	service_type_id int primary key auto_increment,
    service_type_name varchar(45)
);

create table rent_type(
	rent_type_id int primary key auto_increment,
    rent_type_name varchar(45),
    rent_type_cost double
);

create table service(
	service_id int primary key auto_increment,
    service_name varchar(45) not null,
    service_area int,
    service_cost double not null,
    service_max_people int,
    standard_room varchar(45),
    description_other_convenience varchar(45),
    pool_area double,
    number_of_floors int,
    rent_type_id int not null,
    service_type_id int not null,
    foreign key(rent_type_id) references rent_type(rent_type_id),
    foreign key(service_type_id) references service_type(service_type_id)
);

create table contract(
	contract_id int primary key auto_increment,
    contract_start_date date not null,
    contract_end_date date not null,
    contract_deposit double not null,
    contract_total_money double not null,
    employee_id int not null,
    customer_id int not null,
    service_id int not null,
    foreign key(employee_id) references employee(employee_id),
    foreign key(customer_id) references customer(customer_id),
    foreign key(service_id) references service(service_id)
);

create table attach_service(
	attach_service_id int primary key auto_increment,
    attach_service_name varchar(45) not null,
    attach_service_cost double not null,
    attach_service_unit int not null,
    attach_service_status varchar(45)
);

create table contract_detail(
	contract_detail_id int primary key auto_increment,
    quantity int not null,
    contract_id int not null,
    attach_service_id int ,
    foreign key(contract_id) references contract(contract_id),
    foreign key(attach_service_id) references attach_service(attach_service_id)
);

	
DROP TABLE contract_detail;

create table account1(
   user_id int primary key auto_increment,
   username varchar(50),
   pass  varchar(50),
   role_id int,
   foreign key(role_id) references role(role_id)
);

INSERT INTO employee  values('');
INSERT INTO customer_type(customer_type.customer_type_id, customer_type.customer_type_name) values(1, "Silver");
INSERT INTO customer_type(customer_type.customer_type_id, customer_type.customer_type_name) values(2, "Gold");
INSERT INTO customer_type(customer_type.customer_type_id, customer_type.customer_type_name) values(3, "Diamond");

-- Tạo trigger khi them nhan viên thi nhan vien đó sẽ nhận một tài khoản
-- DELIMITER $$
-- CREATE TRIGGER create_employee_account
-- AFTER INSERT ON employee FOR EACH ROW
-- BEGIN
-- CALL create_employee(new.employee_email, "123",1);
-- END $$
-- DELIMITER ;

-- DELIMITER $$
-- CREATE PROCEDURE create_employee(in username1 int, in pass1 varchar(50), in role_id1 int)
-- BEGIN
-- 	INSERT INTO account1(username,pass,role_id) VALUES(username1,pass1,role_id1);
-- END $$
-- DELIMITER ;

delimiter //
create trigger save_account_employee
before insert
on employee for each row
begin
	insert into account1(username,pass,role_id)
    values (new.employee_email, "123",1);
    
    if employee.employee_user_id is null then
		set new.user_id = account1.user_id;
    end if;
end;
// delimiter ;

-- DELIMITER $$
-- CREATE TRIGGER create_employee_user_id
-- AFTER INSERT ON account1 FOR EACH ROW
-- BEGIN
-- CALL create_user_id(new.user_id);
-- END $$
-- DELIMITER ;

-- Tạo procedure


-- DELIMITER $$
-- CREATE PROCEDURE create_user_id(in user_id_1 int)
-- BEGIN
-- 	INSERT INTO employee(user_id) VALUES(user_id_1);
-- END $$
-- DELIMITER ;


-- Thêm dữ liệu cho position
INSERT INTO `position`(position_id, position_name) VALUES (1, "Manager");
INSERT INTO `position`(position_id, position_name) VALUES (2, "Director");
INSERT INTO `position`(position_id, position_name) VALUES (3, "Chairman");

-- Thêm dữ liệu cho education degree
INSERT INTO education_degree(education_degree_id, education_degree_name) VALUES (1, "High School");
INSERT INTO education_degree(education_degree_id, education_degree_name) VALUES (2, "College");
INSERT INTO education_degree(education_degree_id, education_degree_name) VALUES (3, "University");

-- Thêm dữ liệu cho division
INSERT INTO division(division_id, division_name) VALUES(1, "accounting");
INSERT INTO division(division_id, division_name) VALUES(2, "technology");
INSERT INTO division(division_id, division_name) VALUES(3, "marketing");

-- Thêm dữ liệu vào bảng rent_type
INSERT INTO rent_type(rent_type_id, rent_type_name, rent_type_cost) VALUES(1, "Week", 7000000);
INSERT INTO rent_type(rent_type_id, rent_type_name, rent_type_cost) VALUES(2, "Month", 25000000);
INSERT INTO rent_type(rent_type_id, rent_type_name, rent_type_cost) VALUES(3, "Year", 250000000);

-- Thêm dữ liệu vào bảng service_type
INSERT INTO service_type(service_type_id, service_type_name) VALUES(1, "VIP");
INSERT INTO service_type(service_type_id, service_type_name) VALUES(2, "NORMAL");

-- Thêm dữ liệu vào bảng service
INSERT INTO service VALUE (1, "VILLA", 1000, 10000000, 5, "Superior", "Thoáng mát, dễ chịu", 100, 3, 1, 1);

-- Thêm dữ liệu vào bảng attach_service
INSERT INTO attach_service VALUE (1, "Karaoke", 500000, 1, "Yes");
INSERT INTO attach_service VALUE (2, "Massage", 700000, 2, "Yes");
INSERT INTO attach_service VALUE (3, "Food", 500000, 1, "Yes");
INSERT INTO attach_service VALUE (4, "Baverage", 300000, 1, "Yes");

drop trigger save_account_employee