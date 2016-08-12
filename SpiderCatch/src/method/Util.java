package method;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.ZhiHuBean;

public class Util {
	public static String SendGet(String url) {
		// 定义一个字符串用来存储网页内容
		String result = "";
		// 定义一个缓冲字符输入流
		BufferedReader in = null;
		try {
			// 将string转成url对象
			URL realUrl = new URL(url);
			// 初始化一个链接到那个url的连接
			URLConnection connection = realUrl.openConnection();
			// 开始实际的连接
			connection.connect();
			// 初始化 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			// 用来临时存储抓取到的每一行的数据
			String line;
			while ((line = in.readLine()) != null) {
				// 遍历抓取到的每一行并将其存储到result里面
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	// 只匹配url
	public static ArrayList<ZhiHuBean> GetRecommendations(String content) {
		// 预定义一个ArrayList来存储结果
		ArrayList<ZhiHuBean> results = new ArrayList<ZhiHuBean>();
		Pattern urlPattern = Pattern.compile("<h2>.+?question_link.+?href=\"(.+?)\".+?</h2>");
		Matcher urlMatcher = urlPattern.matcher(content);
		// 问题和链接要均能匹配到
		boolean isFind = urlMatcher.find();
		while (isFind) {
			// 定义一个知乎对象来存储抓取到的信息
			ZhiHuBean zhuhuTemp = new ZhiHuBean(urlMatcher.group(1));
			// 添加成功匹配的结果
			results.add(zhuhuTemp);
			// 继续查找下一个匹配对象
			isFind = urlMatcher.find();
		}
		return results;
	}
	
	//存储当前精华页面下的用户url
	public static List<String> getUserUrl(String url) {
		//新建一个List存放用户url列表
		List<String> userUrls = new ArrayList<String>();
		String content = Util.SendGet(url);
		Pattern pattern;
		Matcher matcher;
		// 用户url
		pattern = Pattern.compile("author-link.+?href=\"(.*?)\">");
		matcher = pattern.matcher(content);
		boolean isFind = matcher.find();
		while (isFind) {
			userUrls.add(matcher.group(1));
			isFind = matcher.find();
		}
		return userUrls;
	}
}
