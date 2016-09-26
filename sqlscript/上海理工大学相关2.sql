use stuinfo;
SET FOREIGN_KEY_CHECKS=0;
set sql_safe_updates=0;

#选择调剂一志愿生源学校排名前11名
#select * from tmptable order by count desc limit 0,11;

#学生总数
select sum(tmptable.count) as '总计' from tmptable;

#各学院人数
select count(*) as '统计人数', collegeName as '学院名称' from stuinfo group by collegeName;

#各学院初试成绩平均分
select avg(stuinfo.firstGrade) as '初试成绩平均分',collegeName as '学院名称' from stuinfo group by collegeName;

#各学院复试成绩平均分
select avg(stuinfo.secondGrade) as '复试成绩平均分',collegeName as '学院名称' from stuinfo group by collegeName;

#各学院录取成绩平均分
select avg(stuinfo.thirdGrade) as '录取成绩平均分',collegeName as '学院名称' from stuinfo group by collegeName;

#各专业初试平均成绩排名
select avg(stuinfo.firstGrade) as '各专业初试成绩平均分',majorName as '专业名称' from stuinfo group by majorName;

#设置一志愿编号变量->@strings
set @strings='10252';

#光电学院总体人数
#select count(*) as '总人数' from stuinfo where collegeName='光电信息与计算机工程学院';
set @total=483;

#光电学院总体初试成绩平均分
select avg(stuinfo.firstGrade) as '总体平均分' from stuinfo where collegeName='光电信息与计算机工程学院';

#光电学院专业人数细分
select count(*) as '统计', majorName as '专业名称' from stuinfo where collegeName='光电信息与计算机工程学院' group by majorName;

#光电学院不同专业初试成绩平均分
select avg(stuinfo.firstGrade) as '总体平均分',majorName as '专业' from stuinfo where collegeName='光电信息与计算机工程学院' group by majorName;

#光电学院一志愿人数总数
#select count(*) as '统计' from stuinfo where collegeName='光电信息与计算机工程学院' and left(stuNumber,5)=@strings;
set @total1=298;

#光电学院各专业一志愿人数
select count(*) as '各专业一志愿统计', majorName as '专业名称' from stuinfo where collegeName='光电信息与计算机工程学院'
 and left(stuNumber,5)=@strings group by majorName;
 
#光电学院一志愿初试成绩平均分
select avg(stuinfo.firstGrade) as '一志愿初试平均分' from stuinfo where collegeName='光电信息与计算机工程学院' and left(stuNumber,5)=@strings;

#光电学院非一志愿初试成绩平均分
select avg(stuinfo.firstGrade) as '非一志愿初试平均分' from stuinfo where collegeName='光电信息与计算机工程学院' and left(stuNumber,5)!=@strings;

#光电学院各专业一志愿初试成绩平均分
select avg(stuinfo.firstGrade) as '各专业一志愿平均分',majorName as '专业名称'  from stuinfo where collegeName='光电信息与计算机工程学院'
 and left(stuNumber,5)=@strings group by majorName;

#光电学院各专业非一志愿初试成绩平均分
select avg(stuinfo.firstGrade) as '各专业非一志愿平均分',majorName as '专业名称'  from stuinfo where collegeName='光电信息与计算机工程学院'
 and left(stuNumber,5)!=@strings group by majorName;