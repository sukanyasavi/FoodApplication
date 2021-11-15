create database  foodo;
use foodo;


create table user_table( 
	user_id integer AUTO_INCREMENT, 
	user_name varchar(50) Not Null,
    password varchar(50),
    email varchar(50),
    address varchar(50),
    ph_number long,
    role varchar(25) default 'user',
    PRIMARY KEY  (user_id));
    
    insert into user_table
(user_name,password,email,address,ph_number,role) 
values 
( 'arp','arp*','arp@gmail.com','blore','98765321','admin');   
insert into user_table
(user_name,password,email,address,ph_number) 
values 
( 'bru','bru*','bru@gmail.com','blore','98765321');  

select * from user_table;
drop table user_table;

create table menu_table(
	dish_Name varchar(50) primary key,
    available_Quantity integer,
    price float,
     ingredients varchar(200),
    date_Of_Updation date,
    dish_img varchar(50));
    
    select * from menu_table;
    drop table menu_table;
    
    create table cart_table(
cart_id integer AUTO_INCREMENT,
    dish_Name varchar(50),
    dish_img varchar(50),
    user_id integer,
    quantity integer,
    price float,
    primary key(cart_id),
    FOREIGN KEY (dish_Name) REFERENCES menu_table(dish_Name),
    FOREIGN KEY (user_id) REFERENCES user_table(user_id));
     alter table cart_table auto_increment=1;
     
    select * from cart_table;
    drop table cart_table;
    
    alter table order_table auto_increment=1;
     select * from order_table;  
     drop table order_table;