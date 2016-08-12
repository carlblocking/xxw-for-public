package method;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;



import bean.JobInfo;

public class Spider {
	public void getInformation() throws Exception{
		DBHelper helper=new DBHelper();
		Connection connection=helper.getConnection();
		Statement statement=connection.createStatement();
		 int page=1;
		 String baseUrl="http://www.lagou.com/zhaopin/";//一定要加http头部，不然出现错误
		 for(page=1;page<=30;page++){
			 String nowUrl=baseUrl+page+"/";
			 List<String> users=Util.getUserUrl(nowUrl);
			 for(String userUrl:users){
				 JobInfo jobInfo=new JobInfo("http://"+userUrl);//一定要加http头部，不然出现错误
				 jobInfo.printInformation();
				 String sqlString="insert into test.job(jobname,jobcompany,salary,minsalary,maxsalary,jobaddress,experience,education,industry,growth) values('"
				 +jobInfo.getJobName()+"','"+jobInfo.getJobCompany()+"','"+jobInfo.getSalary()+"','"+jobInfo.getMinSalary()+"','"+jobInfo.getMaxSalary()+
				 "','"+jobInfo.getJobAddress()+"','"+jobInfo.getExperience()+"','"+jobInfo.getEducation()+"','"+jobInfo.getIndustry()+"','"+jobInfo.getGrowth()+"')";
				 if(statement.execute(sqlString)){
					 System.out.println("执行失败");
				 }else {
					System.out.println("执行成功");
				 }
				 System.out.println("-----------------------");
			 }
		 }
		 connection.close();
	}
}
