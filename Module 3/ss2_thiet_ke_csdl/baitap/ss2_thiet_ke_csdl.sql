use ss2_thiet_ke_csdl;

create table customer(
cID int primary key auto_increment,
cName varchar(50),
cAge varchar(50)
);

create table oder(
oID int primary key auto_increment,
cID int ,
oDate date,
oTotalPrice varchar(50),
foreign key(cID) references customer(cID)
);

create table product (
pID int primary key auto_increment,
pName varchar(50),
pPrice varchar(50)
);

create table oder_detail (
oID int primary key  ,
pID int primary key  ,
odQTy varchar(50),
foreign key(oID) references oder(oID),
foreign key(pID) references product(pID)
);