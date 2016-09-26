use stuinfo;
SET FOREIGN_KEY_CHECKS=0;
set sql_safe_updates=0;

/*
通过导入文件的方式导入数据(源文件是excel)
网址链接：http://zhidao.baidu.com/link?url=rvJcXtr9JQ7IWjBqsxgIBhy-zbMmrO7RLkUI7X1pLuVCg7v8i4Z27eN3xMeyn1KJZUmRyeIng_Lu0U7ilLUI2q
load data local infile 'C:/Users/xxw/Desktop/list2.txt' into table stuinfo fields terminated by '\t';
*/

#select count(*) from stuinfo;
#select count(*) as '统计', collegeName as '学院' from stuinfo.stuinfo group by collegeName;
#select count(*) as '统计', majorName as '学院' from stuinfo.stuinfo group by majorName;
#select avg(stuinfo.firstGrade) as '初试成绩' from stuinfo.stuinfo;
#select avg(stuinfo.secondGrade) as '复试成绩' from stuinfo.stuinfo;
#select avg(stuinfo.thirdGrade) as '录取成绩' from stuinfo.stuinfo;

#select avg(stuinfo.firstGrade) as '各学院初试成绩',stuinfo.collegeName as '学院' from stuinfo.stuinfo group by stuinfo.collegeName;
#select avg(stuinfo.firstGrade) as '各专业初试成绩',stuinfo.majorName as '专业' from stuinfo.stuinfo  where stuinfo.collegeName ='光电信息与计算机工程学院' group by stuinfo.majorName;

#22行用来统计一志愿和非一志愿学生的数量
#select count(*) as 统计,left(stuinfo.stuNumber,5) as '一志愿学校代码' from stuinfo.stuinfo group by left(stuinfo.stuNumber,5) ;

#插入表格数据
#insert into tmptable(count,number) select count(*) ,left(stuinfo.stuNumber,5)from stuinfo.stuinfo group by left(stuinfo.stuNumber,5);

#调用函数call语句
#call myproc1();//这行是用来调用函数的

#定义函数
/*
delimiter 
create procedure myproc1() 
begin 
declare num int; 
set num=2; 
while num <112 do 
select @strings:=schoolName from schoolnumber where schoolID = (select number from tmptable where tmptable.id=num);
UPDATE stuinfo.tmptable SET name=@strings  WHERE id=num;
set num=num+1;
end while;
end
*/

#查询学生总数
#select sum(tmptable.count) from tmptable;











