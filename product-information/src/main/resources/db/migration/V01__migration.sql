DROP TABLE IF EXISTS `prices`;

CREATE TABLE `prices` (
  `id` int NOT NULL AUTO_INCREMENT,
  `brand_id` int NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `price_list` int NOT NULL,
  `product_id` int NOT NULL,
  `priority` int NOT NULL,
  `price` double NOT NULL,
  `curr` varchar(10) NOT NULL
);

INSERT INTO `prices` VALUES (1,1,'2020-06-14 00:00:00','2020-12-31 23:59:59',1,35455,0,35.5,'EUR'),(2,1,'2020-06-14 15:00:00','2020-06-14 18:30:00',2,35455,1,25.45,'EUR'),(3,1,'2020-06-15 00:00:00','2020-06-15 11:00:00',3,35455,1,30.5,'EUR'),(4,1,'2020-06-15 16:00:00','2020-12-31 23:59:59',4,35455,1,38.95,'EUR');