package test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test7 {
	public static void main(String[] args) {
		String url="http://www.lagou.com/zhaopin/1";
		try {
			Document document=Jsoup.connect(url).get();
			//Elements hrefs=document.select("a");
			Elements hrefs=document.getElementsByClass("position_link");
			for(Element element:hrefs){
				System.out.println(element.attr("href").replace("//", ""));
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
