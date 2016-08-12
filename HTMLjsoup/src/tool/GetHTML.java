package tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetHTML {
	public String getHtml(String url){
		String result=null;
		try {
			URL realUrl=new URL(url);
			URLConnection connection=realUrl.openConnection();
			BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
			while(reader.readLine()!=null){
				result+=reader.readLine();
			}
			return result;
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
