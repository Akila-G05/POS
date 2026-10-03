/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `shop_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shop_db`;

CREATE TABLE IF NOT EXISTS `brand` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

INSERT INTO `brand` (`id`, `name`) VALUES
	(1, 'Maliban'),
	(2, 'Munchee'),
	(3, 'Coca Cola'),
	(4, 'gg');

CREATE TABLE IF NOT EXISTS `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

INSERT INTO `city` (`id`, `name`) VALUES
	(1, 'Sample City'),
	(2, 'Kandy'),
	(3, 'Colombo'),
	(4, 'Gampaha');

CREATE TABLE IF NOT EXISTS `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `hotline` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

INSERT INTO `company` (`id`, `name`, `hotline`) VALUES
	(1, 'Maliban', '0770000003'),
	(2, 'Munchee', '0770000004');

CREATE TABLE IF NOT EXISTS `customer` (
  `mobile` varchar(10) NOT NULL,
  `frist_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `points` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO `customer` (`mobile`, `frist_name`, `last_name`, `email`, `points`) VALUES
	('0770000001', 'Meraj', 'Lakvindu', 'customer.one@example.com', 8.4),
	('0764012265', 'Akila', 'Gimhana', 'admin@example.com', 0),
	('0770000002', 'Sahan', 'Rohith', 'customer.two@example.com', 0);

CREATE TABLE IF NOT EXISTS `employee` (
  `email` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `frist_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `nic` varchar(20) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `employee_type_id` int NOT NULL,
  `date_registerd` date DEFAULT NULL,
  `gender_id` int NOT NULL,
  PRIMARY KEY (`email`),
  KEY `fk_employee_employee_type1_idx` (`employee_type_id`),
  KEY `fk_employee_gender1_idx` (`gender_id`),
  CONSTRAINT `fk_employee_employee_type1` FOREIGN KEY (`employee_type_id`) REFERENCES `employee_type` (`id`),
  CONSTRAINT `fk_employee_gender1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO `employee` (`email`, `password`, `frist_name`, `last_name`, `nic`, `mobile`, `employee_type_id`, `date_registerd`, `gender_id`) VALUES
	('admin@example.com', '123456', 'Akila', 'Gimhana', '200532701893', '0764012265', 1, '2023-07-19', 1),
	('cashier@example.com', '123456', 'oshan', 'sam', '000000000000', '0770000005', 2, '2023-07-19', 2);

CREATE TABLE IF NOT EXISTS `employee_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `line1` varchar(45) DEFAULT NULL,
  `line2` varchar(45) DEFAULT NULL,
  `city_id` int NOT NULL,
  `employee_email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Employee_address_city_idx` (`city_id`),
  KEY `fk_Employee_address_employee1_idx` (`employee_email`),
  CONSTRAINT `fk_Employee_address_city` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `fk_Employee_address_employee1` FOREIGN KEY (`employee_email`) REFERENCES `employee` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

INSERT INTO `employee_address` (`id`, `line1`, `line2`, `city_id`, `employee_email`) VALUES
	(1, 'Sample City', 'Sample City', 1, 'admin@example.com'),
	(3, 'No. 12', 'Sample City', 1, 'admin@example.com');

CREATE TABLE IF NOT EXISTS `employee_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

INSERT INTO `employee_type` (`id`, `name`) VALUES
	(1, 'Admin'),
	(2, 'Cashier');

CREATE TABLE IF NOT EXISTS `gender` (
  `id` int NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO `gender` (`id`, `name`) VALUES
	(1, 'Male'),
	(2, 'Female');

CREATE TABLE IF NOT EXISTS `grn` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `supplier_mobile` varchar(10) NOT NULL,
  `employee_email` varchar(45) NOT NULL,
  `date_time` datetime DEFAULT NULL,
  `paid_amount` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grn_supplier1_idx` (`supplier_mobile`),
  KEY `fk_grn_employee1_idx` (`employee_email`),
  CONSTRAINT `fk_grn_employee1` FOREIGN KEY (`employee_email`) REFERENCES `employee` (`email`),
  CONSTRAINT `fk_grn_supplier1` FOREIGN KEY (`supplier_mobile`) REFERENCES `supplier` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=1690821268931 DEFAULT CHARSET=utf8mb3;

INSERT INTO `grn` (`id`, `supplier_mobile`, `employee_email`, `date_time`, `paid_amount`) VALUES
	(1690820776180, '0754012265', 'admin@example.com', '2023-07-31 21:56:50', 700),
	(1690821268930, '0754012265', 'admin@example.com', '2023-07-31 22:04:56', 900);

CREATE TABLE IF NOT EXISTS `grn_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stock_id` int NOT NULL,
  `qty` double DEFAULT NULL,
  `buying_price` double DEFAULT NULL,
  `grn_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grn_item_stock1_idx` (`stock_id`),
  KEY `fk_grn_item_grn1_idx` (`grn_id`),
  CONSTRAINT `fk_grn_item_grn1` FOREIGN KEY (`grn_id`) REFERENCES `grn` (`id`),
  CONSTRAINT `fk_grn_item_stock1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE IF NOT EXISTS `invoice` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `customer_mobile` varchar(10) NOT NULL,
  `employee_email` varchar(45) NOT NULL,
  `date_time` datetime DEFAULT NULL,
  `payed_amount` double DEFAULT NULL,
  `payment_method_id` int NOT NULL,
  `discount` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_customer1_idx` (`customer_mobile`),
  KEY `fk_invoice_payment_method1_idx` (`payment_method_id`),
  KEY `fk_invoice_employee1_idx` (`employee_email`),
  CONSTRAINT `fk_invoice_customer1` FOREIGN KEY (`customer_mobile`) REFERENCES `customer` (`mobile`),
  CONSTRAINT `fk_invoice_employee1` FOREIGN KEY (`employee_email`) REFERENCES `employee` (`email`),
  CONSTRAINT `fk_invoice_payment_method1` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1691256922759 DEFAULT CHARSET=utf8mb3;

INSERT INTO `invoice` (`id`, `customer_mobile`, `employee_email`, `date_time`, `payed_amount`, `payment_method_id`, `discount`) VALUES
	(1691256218866, '0770000001', 'admin@example.com', '2023-08-05 22:54:34', 350, 2, 200),
	(1691256922758, '0770000001', 'admin@example.com', '2023-08-05 23:06:26', 200, 1, 40);

CREATE TABLE IF NOT EXISTS `invoice_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stock_id` int NOT NULL,
  `qty` double DEFAULT NULL,
  `invoice_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_item_stock1_idx` (`stock_id`),
  KEY `fk_invoice_item_invoice1_idx` (`invoice_id`),
  CONSTRAINT `fk_invoice_item_invoice1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`),
  CONSTRAINT `fk_invoice_item_stock1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

INSERT INTO `invoice_item` (`id`, `stock_id`, `qty`, `invoice_id`) VALUES
	(1, 5, 5, 1691256218866),
	(2, 5, 2, 1691256922758);

CREATE TABLE IF NOT EXISTS `payment_method` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

INSERT INTO `payment_method` (`id`, `name`) VALUES
	(1, 'Cash'),
	(2, 'Card');

CREATE TABLE IF NOT EXISTS `product` (
  `id` varchar(20) NOT NULL,
  `brand_id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_brand1_idx` (`brand_id`),
  CONSTRAINT `fk_product_brand1` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO `product` (`id`, `brand_id`, `name`) VALUES
	('1', 3, 'sasa'),
	('2', 2, 'Chcolate'),
	('323', 1, 'Mari');

CREATE TABLE IF NOT EXISTS `stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` varchar(20) NOT NULL,
  `selling_price` double DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `mfd` date DEFAULT NULL,
  `exp` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stock_product1_idx` (`product_id`),
  CONSTRAINT `fk_stock_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

INSERT INTO `stock` (`id`, `product_id`, `selling_price`, `qty`, `mfd`, `exp`) VALUES
	(4, '1', 100, 10, '2023-07-01', '2023-07-31'),
	(5, '2', 120, 3, '2023-07-12', '2023-07-28');

CREATE TABLE IF NOT EXISTS `supplier` (
  `mobile` varchar(10) NOT NULL,
  `frist_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`mobile`),
  KEY `fk_supplier_company1_idx` (`company_id`),
  CONSTRAINT `fk_supplier_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO `supplier` (`mobile`, `frist_name`, `last_name`, `email`, `company_id`) VALUES
	('0754012265', 'asdddd', 'dasddd', 'customer.three@example.com', 1),
	('0770000007', 'dasdsad', 'sadasd', 'customer.four@example.com', 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
