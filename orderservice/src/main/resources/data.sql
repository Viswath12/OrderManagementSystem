drop table if exists orders;

CREATE TABLE orders (
  id bigint PRIMARY KEY auto_increment,
  customer_name VARCHAR(50) NOT NULL,
  order_date SMALLDATETIME,
  shipping_address VARCHAR(50) NOT NULL,
  total decimal(20, 2)
);

insert into orders(customer_name, order_date, shipping_address, total)
values ('Tom', '2020-07-21 06:15:15', 'Blk 1, Area 1, Singapore', 1200.28),
('Jerry', '2020-07-21 12:30:18', 'Blk 2, Area 1, Singapore', 200.99),
('Pluto', '2020-07-21 20:50:56', 'Blk 3, Area 1, Singapore', 700.63);