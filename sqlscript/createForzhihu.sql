use test;
SET FOREIGN_KEY_CHECKS=0;
CREATE TABLE `finance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT '' COMMENT '姓名',
  `location` varchar(255) DEFAULT NULL COMMENT '居住地',
  `business` varchar(255) DEFAULT NULL COMMENT '行业',
  `employment` varchar(255) DEFAULT NULL COMMENT '公司',
  `position` varchar(255) DEFAULT NULL COMMENT '职位',
  `education` varchar(255) DEFAULT NULL COMMENT '大学',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `userInfo` varchar(4096) DEFAULT NULL COMMENT '个人简介',
  `answersNum` int(11) DEFAULT NULL COMMENT '答题数',
  `starsNum` bigint(20) DEFAULT NULL COMMENT '被赞同数',
  `thxNum` bigint(20) DEFAULT NULL COMMENT '被感谢数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;
CREATE TABLE `law` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT '' COMMENT '姓名',
  `location` varchar(255) DEFAULT NULL COMMENT '居住地',
  `business` varchar(255) DEFAULT NULL COMMENT '行业',
  `employment` varchar(255) DEFAULT NULL COMMENT '公司',
  `position` varchar(255) DEFAULT NULL COMMENT '职位',
  `education` varchar(255) DEFAULT NULL COMMENT '大学',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `userInfo` varchar(4096) DEFAULT NULL COMMENT '个人简介',
  `answersNum` int(11) DEFAULT NULL COMMENT '答题数',
  `starsNum` bigint(20) DEFAULT NULL COMMENT '被赞同数',
  `thxNum` bigint(20) DEFAULT NULL COMMENT '被感谢数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;
CREATE TABLE `civil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT '' COMMENT '姓名',
  `location` varchar(255) DEFAULT NULL COMMENT '居住地',
  `business` varchar(255) DEFAULT NULL COMMENT '行业',
  `employment` varchar(255) DEFAULT NULL COMMENT '公司',
  `position` varchar(255) DEFAULT NULL COMMENT '职位',
  `education` varchar(255) DEFAULT NULL COMMENT '大学',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `userInfo` varchar(4096) DEFAULT NULL COMMENT '个人简介',
  `answersNum` int(11) DEFAULT NULL COMMENT '答题数',
  `starsNum` bigint(20) DEFAULT NULL COMMENT '被赞同数',
  `thxNum` bigint(20) DEFAULT NULL COMMENT '被感谢数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;
CREATE TABLE `chemistry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT '' COMMENT '姓名',
  `location` varchar(255) DEFAULT NULL COMMENT '居住地',
  `business` varchar(255) DEFAULT NULL COMMENT '行业',
  `employment` varchar(255) DEFAULT NULL COMMENT '公司',
  `position` varchar(255) DEFAULT NULL COMMENT '职位',
  `education` varchar(255) DEFAULT NULL COMMENT '大学',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `userInfo` varchar(4096) DEFAULT NULL COMMENT '个人简介',
  `answersNum` int(11) DEFAULT NULL COMMENT '答题数',
  `starsNum` bigint(20) DEFAULT NULL COMMENT '被赞同数',
  `thxNum` bigint(20) DEFAULT NULL COMMENT '被感谢数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;
CREATE TABLE `macromolecule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT '' COMMENT '姓名',
  `location` varchar(255) DEFAULT NULL COMMENT '居住地',
  `business` varchar(255) DEFAULT NULL COMMENT '行业',
  `employment` varchar(255) DEFAULT NULL COMMENT '公司',
  `position` varchar(255) DEFAULT NULL COMMENT '职位',
  `education` varchar(255) DEFAULT NULL COMMENT '大学',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `userInfo` varchar(4096) DEFAULT NULL COMMENT '个人简介',
  `answersNum` int(11) DEFAULT NULL COMMENT '答题数',
  `starsNum` bigint(20) DEFAULT NULL COMMENT '被赞同数',
  `thxNum` bigint(20) DEFAULT NULL COMMENT '被感谢数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;