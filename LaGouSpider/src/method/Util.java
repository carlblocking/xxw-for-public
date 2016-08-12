package method;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Util {
	public static List<String> getUserUrl(String string){
		List<String> userUrls=new ArrayList<String>();
		try {
			Document document=Jsoup.connect(string).get();
			Elements hrefs=document.getElementsByClass("position_link");
			for(Element element:hrefs){
				userUrls.add(element.attr("href").replace("//", ""));
			}
			return userUrls;
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
