drop database if exists HMS;
create database HMS;

 

use HMS;

 

create table DOCTOR_MASTER(
doctor_id varchar(30),
doctor_name varchar(30),
Dept varchar(30) ,
primary key(doctor_id)
);
insert into DOCTOR_MASTER (doctor_id ,doctor_name ,Dept)
Values('D1','sreenath','Eye'),
('D2','biju','Eye'),
('D3','sandeep','lungs'),
('D4','Gowtham','Nervel'),
('D5','nandini','Nerval'),
('D6','sruthi','Nerval');
select* from DOCTOR_MASTER;

 


create table ROOM_MASTER
(room_no varchar(20),
room_type varchar(20),
status varchar(20)
);
insert into ROOM_MASTER(room_no,room_type ,status)
VALUES('R1','Gendral','vacant'),
('R2','AC','occupied'),
('R3','NonAC','in service'),
('R4','NonAC','occupied'),
('R','Seprate','vacant'),
('R0006','Seprate','occupied');

 

 

 

create table PATIENT_MASTER
(
pid varchar(25),
name varchar(30),
age numeric,
weight numeric ,
gender varchar(8),
address varchar(30),
phoneno numeric(11),
disease varchar(25),
doctor_id varchar(30) ,
foreign key (doctor_id) references DOCTOR_MASTER(doctor_id)
);
insert into PATIENT_MASTER(pid,name ,age ,weight ,gender ,address ,phoneno ,disease ,doctor_id )
Values('P1','sreenath','22','56','F','kerala','87876756478','Eye Infection','D2'),
('P2','Gowtham','54','65','M','coimbature','7897685675','Leg pain','D3'),
('P3','suresh','25','45','F','bangalore','9324564534','Brain Tumer','D5'),
('P4','priya','64','55','F','Kolkata','8655656565','Eye Infection','D1'),
('P5','tilak','75','65','M','Hyderabad','989876789','Nurve pain','D4');

 

 

 

create table ROOM_ALLOCATION
(room_no varchar(30),
pid varchar(25),
admission_date varchar(25) ,
release_date varchar(25)
);

 

insert into ROOM_ALLOCATION (room_no , pid ,admission_date ,release_date )
values ( 'R1','P1','11-sep-20','21-sep-20'),
('R2','P2','21-dec-20','22-dec-20'),
('R2','P3','31-jan-21','03-jan-21');

-- find no male and female

select gender ,count('M'),count('F')
from PATIENT_MASTER; 


-- admitted in jan month

select * from ROOM_ALLOCATION; 
select* from ROOM_ALLOCATION where monthname(admission_date)='jan'; 

-- never alloted to any patient 

select room_no 
from ROOM_ALLOCATION 
group by room_no 
having count(room_no)>1; 


--Allocated  more than once 

SELECT room_no,room_type
from ROOM_MASTER
where room_no in( select room_no from room_allocation group by room_no HAVING count(room_no)>1); 



  select *  from PATIENT_MASTER where disease not like 'Asthma';

  




select doctor_name,D.doctor_id,name,P.pid,R.room_no,admission_date,RM.Room_type
 
 from  doctor_master D inner join patient_master P on 
 D.doctor_id=P.doctor_id
 inner join Room_allocation R on 
 R.pid=P.pid
 inner join Room_master RM on
 Rm.Room_no=R.Room_no;