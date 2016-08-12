package test;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Document document=Jsoup.connect("http://www.lagou.com/jobs/857555.html").get();
			Element element=document.select("meta[name]").get(2);
			
			/*获得含有工作名称、公司名称的字符串,之后可以进行进一步的解析*/
			System.out.println(element.attr("content"));
			
			/*获得工资字符串*/
			Element salary=document.getElementsByTag("span").get(3);
			System.out.println(salary.text());
			
			/*获得公司地址*/
			Element address=document.getElementsByTag("span").get(4);
			System.out.println(address.text());
			
			/*获得工作经验*/
			Element experience=document.getElementsByTag("span").get(5);
			System.out.println(experience.text());
			
			/*获得学历要求*/
			Element education=document.getElementsByTag("span").get(6);
			System.out.println(education.text());	
			
			/*查找领域、融资情况*/
			Elements results=document.select(".c_feature").select("li");
			
			/*领域*/
			System.out.println(results.get(0).text());
			
			/*融资*/
			System.out.println(results.get(3).text());
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
