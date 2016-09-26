use test;
SET FOREIGN_KEY_CHECKS=0;
CREATE TABLE `houseInfo` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT '' COMMENT '小区',
  `decoration` varchar(255) DEFAULT NULL COMMENT '装修程度',
  `district` varchar(255) DEFAULT NULL COMMENT '所属市区',
  `houseType` varchar(255) DEFAULT NULL COMMENT '房屋类型',
  `price` int(11) DEFAULT NULL COMMENT '月租金',
  `rentType` varchar(255) DEFAULT NULL COMMENT '出租类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;