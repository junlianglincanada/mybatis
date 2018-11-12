DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL DEFAULT '',
  `price` DECIMAL (10,2) NOT NULL DEFAULT 0,
  `catagory_id` INT(11) NULL ,
  `user_id`  INT(11) NULL ,
  `vendor_id`  INT(11) NULL ,
  PRIMARY KEY (`id`)
);

INSERT INTO `t_product` (name,price,catagory_id,user_id,vendor_id) VALUES ('Boots',255.23,1,1,1);
--INSERT INTO `t_role` VALUES (1,'ADMIN');
--INSERT INTO `t_role` VALUES (2,'REGISTERED');


