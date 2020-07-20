drop table if exists order_items;

create table order_items (
	id bigint PRIMARY KEY auto_increment,
	order_id bigint NOT NULL,
	code VARCHAR(20) NOT NULL,
 	name VARCHAR(50) NOT NULL,
 	quantity int
);

insert into order_items (code, order_id, name, quantity)
values ('MP', 1, 'Phone', 100),
('LT', 1, 'Laptop', 50),
('TB', 2, 'Tablet', 20),
('MP', 2, 'Phone', 100),
('LT', 3, 'Laptop', 50),
('TB', 3, 'Tablet', 20);