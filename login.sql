create database Form;
 use Form;
 
create table fill(
firstName varchar(20),
lastName varchar(20),
email varchar(20),
phone_number varchar(20),
gender varchar(20),
birthday varchar(20),
userName varchar(20) primary key ,
password varchar(20)
); 

insert into fill(firstName) values('Ebenezer');
insert into fill(firstName , lastName , email , userName , password ) values('Ebe','Mulu','ebenemulu@gmail.com','Eb','1234');

select *from fill;




 
