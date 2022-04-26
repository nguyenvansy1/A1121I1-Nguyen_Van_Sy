use quan_ly_ban_hang;


create table customer(
cID int primary key auto_increment,
cName varchar(50),
cAge int
);

create table oder(
oID int primary key auto_increment,
cID int ,
oDate date,
oTotalPrice int ,
foreign key(cID) references customer(cID)
);

create table product (
pID int primary key auto_increment,
pName varchar(50),
pPrice int
);

create table oder_detail (
oID int  ,
pID int   ,
odQTy int,
foreign key(oID) references oder(oID),
foreign key(pID) references product(pID)
);

insert into oder_detail values (1,1,3);
insert into oder_detail values (1,3,7);
insert into oder_detail values (1,4,2);
insert into oder_detail values (2,1,1);
insert into oder_detail values (3,1,8);
insert into oder_detail values (2,5,4);
insert into oder_detail values (2,3,3);

select oder.oID,oder.oDate,oder.oTotalPrice from oder;
select customer.cID ,customer.cName,customer.cAge, product.pID,product.pName from customer
left join oder on oder.cID = customer.cID
left join  oder_detail on oder_detail.oID = oder.oID
left join product on product.pID = oder_detail.pID
where customer.cID in (select oder.cID from oder);


select customer.cID ,customer.cName,customer.cAge, product.pID,product.pName from customer
left join oder on oder.cID = customer.cID
left join  oder_detail on oder_detail.oID = oder.oID
left join product on product.pID = oder_detail.pID
where customer.cID not in (select oder.cID from oder);

select oder.oId ,oder.oDate,sum(product.pPrice*odQTy) from customer
left join oder on oder.cID = customer.cID
left join  oder_detail on oder_detail.oID = oder.oID
left join product on product.pID = oder_detail.pID
group by oder.oID
