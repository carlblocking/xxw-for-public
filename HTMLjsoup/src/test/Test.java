package test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import tool.GetHTML;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//GetHTML getHTML=new GetHTML();
		//String html=getHTML.getHtml("http://www.open-open.com/jsoup/parse-body-fragment.htm");
		//Document document=Jsoup.parseBodyFragment(html);
		//Element body=document.body();
		//System.out.println(body.toString());
		//String title=document.getElementsByTag("body").toString();
		//System.out.println(title);
		try {
			Document document=Jsoup.connect("http://www.lagou.com/jobs/2169529.html?source=home_hot&i=home_hot-0").get();
			Elements links=document.getElementsByTag("meta");
			for (Element link:links) {
				System.out.println(link.attr("name"));
				System.out.println(link.attr("content"));
				//System.out.println(link.text());
				System.out.println("---------------------");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
