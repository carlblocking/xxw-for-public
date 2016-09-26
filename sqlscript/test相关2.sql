set sql_safe_updates=0;
/*11行用于删除重复的数据*/
DELETE from test.user WHERE id IN (select id from (select id from test.user group by test.user.name having count(test.user.name)>1) t );