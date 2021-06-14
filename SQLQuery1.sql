drop database OLX
create database OLX
use OLX


------------------------------------------------------------------------------------
drop table sellermessages
create table SellerMessages
(
sellerId int foreign key references Users(id),
userMessage varchar(100)
)

drop table Ad
create table Ad
(
id int primary key,
title varchar(50),
picture varchar(50),
price int,
description varchar(50),
category varchar(50),
discountFactor float,
--sellerId int foreign key references Users(id)
sellerName varchar(50)
)

drop table report
create table Report
(
id int primary key,
ad_id int foreign key references Ad(id),
reportType varchar(50),
description varchar(500)
)


create table Users
(
id int primary key,
name varchar(50),
username varchar(50),
password varchar(50),
email varchar(50),
phone varchar(50),
address varchar(500)
)

create table Person --admins are also persons in DB
(
id int primary key,
name varchar(50),
username varchar(50),
password varchar(50),
email varchar(100)
)

create table Bank
(
id int primary key,
name varchar(50)
)

create table Event
(
id int primary key,
title varchar(50),
startDate date,
endDate date,
place varchar(50),
noOfProducts int
)

create table Orders
(
id int primary key,
totalPrice int,
totalDiscount int
)




select @@servername

select * from ad
select * from seller
select * from Users
select * from Report

------------------------------------


select *
from ad
where ad.category ='car'