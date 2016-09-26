use test;
SET FOREIGN_KEY_CHECKS=0;
SELECT * FROM test.job;
select count(*) from test.job;
select jobAddress as '工作地点',count(*) as '统计数' from test.job group by jobAddress;
select education as '融资情况',count(*) as '统计数' from test.job group by education;
select test.job.growth as '融资情况' ,count(*) as '统计数' from test.job group by  growth;
select salary as '收入', count(*) as '统计' from (select * from job where education='大专及以上' ) as aa group by salary;
select salary as '收入', count(*) as '统计' from (select * from job where experience='经验1-3年' ) as aa group by salary;
select salary as '收入', count(*) as '统计' from (select * from job where experience='经验3-5年' ) as aa group by salary;
select salary as '收入', count(*) as '统计' from (select * from job where experience='经验5-10年' ) as aa group by salary;
select salary as '收入', count(*) as '统计' from (select * from job where experience='经验1年以下' ) as aa group by salary;
select salary as '收入', count(*) as '统计' from (select * from job where experience='经验不限' ) as aa group by salary;
select salary as '收入',jobAddress as'城市', count(*) as '统计' from (select * from job where jobAddress='北京' ) as aa group by salary;
select salary as '收入',jobAddress as'城市', count(*) as '统计' from (select * from job where jobAddress='杭州' ) as aa group by salary;
select salary as '收入',jobAddress as'城市', count(*) as '统计' from (select * from job where jobAddress='上海' ) as aa group by salary;
select salary as '收入',jobAddress as'城市', count(*) as '统计' from (select * from job where jobAddress='深圳' ) as aa group by salary;
select salary as '收入',jobAddress as'城市', count(*) as '统计' from (select * from job where jobAddress='广州' ) as aa group by salary;
select salary as '收入',jobAddress as'城市', count(*) as '统计' from (select * from job where jobAddress='成都' ) as aa group by salary;


