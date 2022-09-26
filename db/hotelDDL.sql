use scott;

drop table member cascade;
drop table hotel cascade;
drop table bookinglist cascade;
drop table room cascade;

create table member (
	member_num int primary key auto_increment,
	id varchar(20) not null,
	pw varchar(20) not null,
	member_name varchar(20) not null,
	tel varchar(20) not null,
	email varchar(20) not null,
	member_grade varchar(20) null,
	position varchar(20) default "member"
);

create table hotel(
	hotel_num int primary key auto_increment,
	hotel_name varchar(20) not null,
	hotel_image varchar(255) not null,
	star double default 0.0,
	location varchar(20) not null,
	hotel_grade varchar(20) not null
);

create table bookinglist (
	booking_num int primary key auto_increment,
	member_num int not null,
	room_num int not null,
	date varchar(20) not null
);

create table room (
	room_num int primary key auto_increment,
	hotel_num int not null,
	room_name varchar(20) not null,
	room_image varchar(255) not null,
	price int not null,
	category varchar(20) not null
);

alter table room add foreign key(hotel_num) references hotel(hotel_num);
alter table bookinglist add foreign key(room_num) references room(room_num);
alter table bookinglist add foreign key(member_num) references member(member_num);
