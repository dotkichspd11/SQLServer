create database PersonalManagement
use PersonalManagement
go
create table Edit (
	Firstname nvarchar (30) not null,
	Lastname nvarchar (50) not null,
	Name nvarchar (50) not null,
	UserName nvarchar (50) not null,
	Password nvarchar (50) not null,
	Birthday nvarchar (50) not null,
	Role nvarchar (50)  not null,
constraint pk_Name primary key (Name)
)
create table Personal (
	No int not null,
	Name nvarchar (50) not null,
	Age int not null,
	Nickname nvarchar (30) not null,
	Role nvarchar (30) not null,
constraint pk_Nickname primary key (Nickname),
constraint fk_Name foreign key (Name) references Edit (Name)
)
insert Edit 
values 
('An' , 'Nguyen Van' ,'Nguyen Van An ', 'an10' , 'a111' ,'11/11/2000', 'Manager'),
('Binh' , 'Tran Thi','Tran Thi Binh' , 'Binh20' , 'B111' ,'12/08/2000', 'Staff'),
('Canh' , 'Le Thi' ,'Le Thi Canh', 'Canh11' , 'c111' ,'11/11/2001', 'Staff'),
('Duyen' , 'Dao Thi','Dao Thi Duyen' , 'Duyen10' , 'ab11' ,'07/11/2000', 'Writer'),
('Em' , 'Nguyen Nam', 'Nguyen Nam Em'  , 'Em10' , 'ac111' ,'08/10/2002', 'Director ')
select *  from Edit 


insert Personal 
values
('1' , 'Nguyen Van An' ,'30' , 'annv' , 'Manager' ),
('2' , 'Tran Thi Binh' ,'23' , 'binhtt' , 'Staff' ),
('3' , 'Le Thi Canh' ,'35' , 'canhlt' , 'Staff' ),
('4' , 'Dao Thi Duyen' ,'50' , 'duyentd' , 'Writer' ),
('5' , 'Nguyen Nam Em' ,'28' , 'emnn' , 'Director' )
select * from Personal 

