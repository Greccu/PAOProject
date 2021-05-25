create database `PAOOOOOOOO`;

use `PAOOOOOOOO`;

drop table `users`;
CREATE TABLE `users` (
`id` varchar(100) NOT NULL,
`username` varchar(100) NOT NULL,
`fullname` varchar(100) NOT NULL,
`email` varchar(100) NOT NULL,
`password` varchar(100) NOT NULL,
`phonenumber` varchar(100) NOT NULL,
`address` varchar(100) NOT NULL,
`cardnumber` varchar(100) NOT NULL,
PRIMARY KEY (`id`));


drop table `drivers`;
CREATE TABLE `drivers` (
`id` varchar(100) NOT NULL,
`carid` varchar(100) NOT NULL,
`brand` varchar(100) NOT NULL,
`model` varchar(100) NOT NULL,
`numberplate` varchar(100) NOT NULL,
`fabricationyear` int NOT NULL,
`horsepower` int NOT NULL,
PRIMARY KEY (`id`));


drop table `products`;
drop table `sellers`;

CREATE TABLE `sellers` (
`id` varchar(100) NOT NULL,
`restaurantid` varchar(100) NOT NULL unique,
`name` varchar(100) NOT NULL,
`address` varchar(100) NOT NULL,
PRIMARY KEY (`id`));


CREATE TABLE `products` (
`id` varchar(100) NOT NULL,
`name` varchar(100) NOT NULL,
`price` double NOT NULL,
`ingredients` varchar(500) NOT NULL,
`restaurantid` varchar(100) NOT NULL,
PRIMARY KEY (`id`)
);

alter table `products` 
add CONSTRAINT `fk_restaurant`
foreign key (`restaurantid`) 
	references `sellers`(`restaurantid`)   
	ON DELETE CASCADE  
	ON UPDATE CASCADE 
;


select * from sellers;


select * from users;

select * from drivers;

select * from products;