
use ss2_chuyen_doi_erd;

create table phieu_xuat(
soPX int primary key ,
NgayXuat date 
);

create table vat_tu(
MaVTU int primary key,
TenVTU varchar(50)
);

create table chi_tiet_phieu_xuat(
soPX  int ,
MaVTU int ,
DGXuat varchar(50),
SLXuat varchar(50),
primary key(soPX,MaVTU),
foreign key(soPX) references phieu_xuat(soPX),
foreign key(MaVTU) references vat_tu(MaVTU)
);


create table phieu_nhap(
SoPN int primary key,
NgayNhap date 
);

create table nha_cc(
MaNCC int primary key ,
TenNCC varchar(50),
dia_chi varchar(50),
sdt varchar(50)
);

create table don_dh(
SoDH int primary key ,
NgayDH date ,
MaNCC int,
foreign key(MaNCC) references nha_cc(MaNCC)
);



create table chi_tiet_don_dat_hang(
SoDH int  ,
MaVTU int,
 primary key(SoDH,MaVTU),
foreign key(SoDH) references don_dh(SoDH),
foreign key(MaVTU) references vat_tu(MaVTU)
);



create table chi_tiet_phieu_nhap(
DGNhap int,
SLNhap int,
MaVTU int ,
SoPN int ,
 primary key(MaVTU,SoPN),
foreign key(SoPN) references phieu_nhap(SoPN),
foreign key(MaVTU) references vat_tu(MaVTU)
);

