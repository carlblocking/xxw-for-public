package test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Document document=Jsoup.connect("http://news.163.com/").get();
			Elements links=document.select("a");
			Elements imgSrc=document.getElementsByTag("img");
			for(Element link:links){
				System.out.println(link.text());
				System.out.println(link.attr("href"));
				System.out.println("----------------");
			}
			for(Element src:imgSrc){
				System.out.println(src.attr("src"));
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
