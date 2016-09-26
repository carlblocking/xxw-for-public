use test;
set sql_safe_updates=0;
select * from test.houseinfo;
select avg(test.houseinfo.price) as '租房平均价格' from houseinfo;
select district as '市区名称',avg(test.houseinfo.price) as '租房平均价格' from houseinfo group by district;
select district as '市区名称',avg(test.houseinfo.price)/3 as '个人平均租房成本' from houseinfo group by district;
select houseType as '房型',avg(test.houseinfo.price) as '不同房型平均租房成本' from houseinfo group by houseType;
select rentType as '出租类型',avg(test.houseinfo.price) as '不同出租方式平均成本' from houseinfo group by rentType;