CREATE DEFINER=`abdul`@`localhost` PROCEDURE `initialize_tables`()
BEGIN

-- Start - Drop Table Scripts --
DROP TABLE IF EXISTS `product_store`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `store`;
DROP TABLE IF EXISTS `region`;
DROP TABLE IF EXISTS `product_category`;
DROP TABLE IF EXISTS `manufacturer`;
DROP TABLE IF EXISTS `halal_status`;
-- End - Drop Table Scripts --

-- Start - Create Table Scripts --
CREATE TABLE `halal_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `manufacturer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `product_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `region` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `store` (
  `id` int NOT NULL AUTO_INCREMENT,
  `region_id` int NOT NULL,
  `name` varchar(150) NOT NULL,
  `address` varchar(999) NOT NULL,
  `zipcode` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `store_region_idx` (`region_id`),
  CONSTRAINT `store_region` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`)
);

CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `category_id` int NOT NULL,
  `manufacturer_id` int NOT NULL,
  `halal_status_id` int DEFAULT NULL,
  `certifications` varchar(999) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_halal_status_idx` (`halal_status_id`),
  KEY `product_manufacturer_idx` (`manufacturer_id`),
  KEY `product_category_idx` (`category_id`),
  CONSTRAINT `product_category` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`id`),
  CONSTRAINT `product_halal_status` FOREIGN KEY (`halal_status_id`) REFERENCES `halal_status` (`id`),
  CONSTRAINT `product_manufacturer` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`id`)
);

CREATE TABLE `product_store` (
  `id` int NOT NULL AUTO_INCREMENT,
  `store_id` int NOT NULL,
  `product_id` int NOT NULL,
  `availability` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_idx` (`product_id`),
  KEY `store_idx` (`store_id`),
  CONSTRAINT `product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `store` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
);
-- End - Create Table Scripts --

-- Start - Insertion Scripts --
INSERT INTO `halal_status`(`id`, `status`) VALUES (1, 'YES');
INSERT INTO `halal_status`(`id`, `status`) VALUES (2, 'NO');
INSERT INTO `halal_status`(`id`, `status`) VALUES (3, 'MAY BE');

INSERT INTO `manufacturer`(`id`, `name`) VALUES (1, 'Crescent Foods');
INSERT INTO `manufacturer`(`id`, `name`) VALUES (2, 'Frito-Lay Inc.');
INSERT INTO `manufacturer`(`id`, `name`) VALUES (3, 'PepsiCo Inc');

INSERT INTO `product_category`(`id`, `name`) VALUES (1, 'Meat');
INSERT INTO `product_category`(`id`, `name`) VALUES (2, 'Chips');
INSERT INTO `product_category`(`id`, `name`) VALUES (3, 'Beverages');

INSERT INTO `region`(`id`, `name`) VALUES (1, 'USA-NorthEast');
INSERT INTO `region`(`id`, `name`) VALUES (2, 'USA-Midwest');
INSERT INTO `region`(`id`, `name`) VALUES (3, 'USA-West');

INSERT INTO `store`(`id`, `region_id`, `name`, `address`, `zipcode`) VALUES (1, 2, 'Walmart', '850 S Barrington Rd, Streamwood, IL', 60107);
INSERT INTO `store`(`id`, `region_id`, `name`, `address`, `zipcode`) VALUES (2, 1, 'Target', '517 E 117th St Suite 201, New York, NY', 10035);
INSERT INTO `store`(`id`, `region_id`, `name`, `address`, `zipcode`) VALUES (3, 3, 'Lucky','2000 California Ave, Sand City, CA', 93955);

INSERT INTO `product`(`id`, `name`, `category_id`, `manufacturer_id`, `halal_status_id`, `certifications`)
VALUES (1, 'Whole Chicken', 1, 1, 1, 'HFSAA');
INSERT INTO `product`(`id`, `name`, `category_id`, `manufacturer_id`, `halal_status_id`)
VALUES (2, 'Whole Chicken', 1, 1, 1);
INSERT INTO `product`(`id`, `name`, `category_id`, `manufacturer_id`, `halal_status_id`)
VALUES (3, 'Whole Chicken', 1, 1, 1);

INSERT INTO `product_store`(`id`, `store_id`, `product_id`, `availability`)
VALUES (1, 1, 1, 1);
INSERT INTO `product_store`(`id`, `store_id`, `product_id`, `availability`)
VALUES (2, 2, 2, 1);
INSERT INTO `product_store`(`id`, `store_id`, `product_id`, `availability`)
VALUES (3, 3, 3, 0);
-- End - Insertion Scripts --

END