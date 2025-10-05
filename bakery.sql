CREATE DATABASE bakeryshop;
USE bakeryshop;

CREATE TABLE orders(
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100),
  product VARCHAR(100),
  price VARCHAR(10)
);
