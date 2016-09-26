use test;
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
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
CREATE TABLE `job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `jobName` varchar(255) DEFAULT null COMMENT '工作名称',
  `jobCompany` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `salary` varchar(255) DEFAULT NULL COMMENT '薪水范围',
  `minSalary` varchar(255) DEFAULT NULL COMMENT '最低薪资',
  `maxSalary` varchar(255) DEFAULT NULL COMMENT '最高薪资',
  `jobAddress` varchar(255) DEFAULT NULL COMMENT '工作地点',
  `experience` varchar(255) DEFAULT NULL COMMENT '工作经验',
  `education` varchar(255) DEFAULT NULL COMMENT '学历要求',
  `industry` varchar(255) DEFAULT NULL COMMENT '领域',
  `growth` varchar(255) DEFAULT NULL COMMENT '融资情况',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;
select count(*) from test.job;
select * from test.job;
select * from test.job where jobName='销售总监';

