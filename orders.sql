create database veeva;
use veeva;

create table orders(id int primary key ,order_date date  ,order_amount  int );
insert into orders(id,order_date,order_amount) values (1,"2023-09-05",1250);
insert into orders(id,order_date,order_amount) values (2,"2023-10-05",950);
insert into orders(id,order_date,order_amount) values (3,"2027-08-05",150);
insert into orders(id,order_date,order_amount) values (5,"2023-12-27",1250);
insert into orders(id,order_date,order_amount) values (4,"2023-11-04",1250);
insert into orders(id,order_date,order_amount) values (6,"2023-11-04",850);
insert into orders(id,order_date,order_amount) values (7,"2023-06-04",50);
insert into orders(id,order_date,order_amount) values (8,"2023-06-04",80);
insert into orders(id,order_date,order_amount) values (9,"2023-07-04",80);
insert into orders(id,order_date,order_amount) values (10,"2027-07-06",80);
insert into orders(id,order_date,order_amount) values (11,"2027-07-06",880);
insert into orders(id,order_date,order_amount,c_id) values (12,"2026-08-15",900,9);
insert into orders(id,order_date,order_amount,c_id) values (13,"2026-08-13",90,9);
insert into orders(id,order_date,order_amount,c_id) values (15,"2026-08-14",100,4);
insert into orders(id,order_date,order_amount,c_id) values (14,"2026-08-15",850,3);

select * from orders;

/*find total orders per day */
select order_date, sum(order_amount) as total from orders group by order_date;

Alter table orders add column c_id int ;
update orders set c_id = 1 where id =1;
update orders set c_id = 2 where id =2;
update orders set c_id = 2 where id =3;
update orders set c_id = 3 where id =5;
update orders set c_id = 2 where id =6;
update orders set c_id = 2 where id =7;
update orders set c_id = 2 where id =8;
update orders set c_id = 2 where id =9;
update orders set c_id = 3 where id =10;
update orders set c_id = 1 where id =11;

create table customer(c_id int primary key ,name varchar(20) ,city varchar(20) );
alter table customer rename column name to c_name;
select * from customer;
insert into customer (c_id,c_name,city) values(1,"Teja","Tpg"),(2,"Fazu","eluru"),(3,"Mounika","Juvvalapalem");

insert into customer (c_id,c_name,city) values(4,"Bhavya","Tpg"),(5,"Faya","eluru"),(9,"Sai","Juvvalapalem");

/*Now we have bith databases those are orders and customer */
/* find total number orders plaed by each customers excluding the orders plaed in june*/
select count(o.id),c.c_id from customer c left join orders o ON c.c_id = o.c_id
AND MONTH(o.order_date) <> 6 group by c.c_id;
SELECT c.c_id, COUNT(o.id) AS total_orders
FROM customer c
LEFT JOIN orders o
    ON c.c_id = o.id
    AND MONTH(o.order_date) <> 6
GROUP BY c.c_id;


/*find customers who have placed highest total order vslue*/

SELECT c.c_id, c.c_name
FROM customer c
JOIN orders o
    ON c.c_id = o.c_id
GROUP BY c.c_id, c.c_name
HAVING SUM(o.order_amount) = (
    SELECT MAX(total)
    FROM (
        SELECT c_id, SUM(order_amount) AS total
        FROM orders
        GROUP BY c_id
    ) x
);

/* list all the orders placed on 2023/07/04and 2027/07/06*/

select id ,order_amount,order_date  from orders where order_date='2023-07-04' or order_date='2027-07-06'; 

/*find avg ordervalue for each city*/
select c.city,avg(o.order_amount) from orders o join customer c on o.c_id=c.c_id group by c.city;

/*identify customer who have not placed any order*/
select c.c_id ,c.c_name from customer c where c.c_id not in (select o.c_id from orders o);

/*find month with highest order value*/
select month(order_date),sum(order_amount) as tot  from orders group by month(order_date) order by tot desc limit 1;

/* isplay top 2 customers with the most orders ni lst 30days*/
select c.c_id,c.c_name,count(*) as order_count from customer c join orders o on c.c_id=o.c_id WHERE o.order_date >= CURRENT_DATE - INTERVAL 30 DAY group by c.c_id 
 order by order_count  desc limit 2;
