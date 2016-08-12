use test;
SET FOREIGN_KEY_CHECKS=0;
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