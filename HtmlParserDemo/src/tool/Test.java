package tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public abstract class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String url="http://www.zhihu.com";
		try {
			URL url2=new URL(url);
			URLConnection connection=url2.openConnection();
			BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
			while (reader.readLine()!=null) {
				System.out.println(reader.readLine());
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}

}
