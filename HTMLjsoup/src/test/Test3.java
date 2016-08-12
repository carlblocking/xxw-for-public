package test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Document document=Jsoup.connect("http://www.lagou.com/jobs/2169529.html?source=home_hot&i=home_hot-0").get();
			//Element link=document.select("meta[name]").last();
			Element link=document.select("meta[name]").get(3);
			System.out.println(link.attr("content"));
/*			for(Element link:links){
				System.out.println(link.attr("content"));
			}*/
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
