package method;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import bean.BaXiangGuiDing;
import bean.BuZhengZhiFeng;

public class Analysis {
	DBHelper helper=new DBHelper();
	Connection connection=helper.getConnection();
	//八项规定
	public void analysis1(String string){
		try {
			Statement statement=connection.createStatement();
			BaXiangGuiDing baXiangGuiDing=null;
			Document document=Jsoup.connect(string).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").get();
			Elements elements=document.select("li.fixed");
			for (Element element:elements) {
				String title=element.getElementsByTag("a").first().attr("title");
				String time=element.getElementsByTag("span").first().text();
				baXiangGuiDing=new BaXiangGuiDing(title, time);
				String sql="insert into zhongjiwei.sum(title,time)values('"+baXiangGuiDing.getTitle()+"','"+
				baXiangGuiDing.getTime()+"')";
				if (statement.execute(sql)) {
					System.out.println("failed....");
				} else {
					System.out.println("success....");
				}
				System.out.println(title);
				System.out.println(time);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//不正之风
	public void analysis2(String string){
		try {
			Statement statement=connection.createStatement();
			BuZhengZhiFeng buZhengZhiFeng=null;
			Document document=Jsoup.connect(string).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").get();
			Elements elements=document.select("li.fixed");
			for (Element element:elements) {
				String title=element.getElementsByTag("a").first().attr("title");
				String time=element.getElementsByTag("span").first().text();
				buZhengZhiFeng=new BuZhengZhiFeng(title, time);
				String sql="insert into zhongjiwei.sum(title,time)values('"+buZhengZhiFeng.getTitle()+"','"+
						buZhengZhiFeng.getTime()+"')";
				if (statement.execute(sql)) {
					System.out.println("failed....");
				} else {
					System.out.println("success....");
				}
				System.out.println(title);
				System.out.println(time);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
