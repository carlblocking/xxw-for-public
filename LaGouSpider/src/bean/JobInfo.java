package bean;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JobInfo {
	//工作名称
	private String jobName;
	//公司名称
	private String jobCompany;
	//薪资范围
	private String salary;
	//最低薪资
	private String minSalary;
	//最高薪资
	private String maxSalary;
	//工作地点
	private String jobAddress;
	//工作经验
	private String experience;
	//学历要求
	private String education;
	//领域
	private String industry;
	//融资情况
	private String growth;
	private String getJobName(String string){
		String jobName=string.substring(0, string.indexOf(","));
		return jobName;
	}
	private String getJobComapany(String string){
		String[] strs=string.split("[,]");
		return strs[2].replace(strs[0]+"招聘", "");
	}	
	public JobInfo(String url){
		jobName="";
		jobCompany="";
		salary="";
		minSalary="";
		maxSalary="";
		jobAddress="";
		experience="";
		education="";
		industry="";
		growth="";
		System.out.println("正在抓取职位信息:"+url);
		try {
			Document document=Jsoup.connect(url).get();
			Element element=document.select("meta[name]").get(2);
			
			/*获得含有工作名称、公司名称的字符串,之后可以进行进一步的解析*/
			String content=element.attr("content");
			jobName=getJobName(content);
			jobCompany=getJobComapany(content);
			
			/*获得工资字符串*/
			salary=document.getElementsByTag("span").get(3).text();
			/*获得最大、最小字符串*/
			String[] salarys=salary.split("[-]");
			try {
				minSalary=salarys[0];
				maxSalary=salarys[1];
			} catch (ArrayIndexOutOfBoundsException e) {
				minSalary=null;
				maxSalary=null;
			}
			/*获得公司地址*/
			jobAddress=document.getElementsByTag("span").get(4).text();
			
			/*获得工作经验*/
			experience=document.getElementsByTag("span").get(5).text();
			
			/*获得学历要求*/
			education=document.getElementsByTag("span").get(6).text();
			
			/*查找领域、融资情况*/
			Elements results=document.select(".c_feature").select("li");
			
			/*领域*/
			industry=results.get(0).text().replace("领域 ", "");
			
			/*融资*/
			growth=results.get(3).text().replace("目前阶段 ", "");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void printInformation(){
		System.out.println("工作名称:"+jobName);
		System.out.println("公司名称:"+jobCompany);
		System.out.println("薪资范围:"+salary);
		System.out.println("最低薪资:"+minSalary);
		System.out.println("最高薪资:"+maxSalary);
		System.out.println("工作地点:"+jobAddress);
		System.out.println("工作经验:"+experience);
		System.out.println("学历要求:"+education);
		System.out.println("所属领域:"+industry);
		System.out.println("融资情况:"+growth);
	}
	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}
	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	/**
	 * @return the jobCompany
	 */
	public String getJobCompany() {
		return jobCompany;
	}
	/**
	 * @param jobCompany the jobCompany to set
	 */
	public void setJobCompany(String jobCompany) {
		this.jobCompany = jobCompany;
	}
	/**
	 * @return the salary
	 */
	public String getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}
	/**
	 * @return the minSalary
	 */
	public String getMinSalary() {
		return minSalary;
	}
	/**
	 * @param minSalary the minSalary to set
	 */
	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}
	/**
	 * @return the maxSalary
	 */
	public String getMaxSalary() {
		return maxSalary;
	}
	/**
	 * @param maxSalary the maxSalary to set
	 */
	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}
	/**
	 * @return the jobAddress
	 */
	public String getJobAddress() {
		return jobAddress;
	}
	/**
	 * @param jobAddress the jobAddress to set
	 */
	public void setJobAddress(String jobAddress) {
		this.jobAddress = jobAddress;
	}
	/**
	 * @return the experience
	 */
	public String getExperience() {
		return experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}
	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * @return the industry
	 */
	public String getIndustry() {
		return industry;
	}
	/**
	 * @param industry the industry to set
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	/**
	 * @return the growth
	 */
	public String getGrowth() {
		return growth;
	}
	/**
	 * @param growth the growth to set
	 */
	public void setGrowth(String growth) {
		this.growth = growth;
	}
	
}
