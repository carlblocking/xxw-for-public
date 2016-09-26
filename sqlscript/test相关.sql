set sql_safe_updates=0;
SELECT * FROM test.user;
select location ,count(location) as total from test.user order by location;
select location as '居住地',count(*) as '统计数' from test.user group by location;
select  * from test.user;
select business as '职业',count(*) as '统计数' from test.user group by business;
select education as '毕业学校',count(*) as '统计数' from test.user group by education;
select * from test.user where location='无锡';
select id from test.user where name='';
/*11行用于删除重复的数据*/
DELETE from test.user WHERE id IN (select id from (select id from test.user group by test.user.name having count(test.user.name)>1) t );
delete from test.user where test.user.name='';
select count(*) from test.user;