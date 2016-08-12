package bean;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import method.Util;

/**
 * 知乎图片bean
 * 
 * @author KKys
 *
 */
public class ZhiHuPicBean {

    String zhihuUrl;// 网页链接
    
	String question;// 问题;
	
	ArrayList<String> zhihuPicUrl;// 图片链接

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ArrayList<String> getZhihuPicUrl() {
		return zhihuPicUrl;
	}

	public void setZhihuPicUrl(ArrayList<String> zhihuPicUrl) {
		this.zhihuPicUrl = zhihuPicUrl;
	}

	// 构造方法初始化数据
	public ZhiHuPicBean(String url) {
		zhihuUrl = "";
		zhihuPicUrl = new ArrayList<String>();
		// 判断url是否合法
		if (getRealUrl(url)) {
			System.out.println("正在抓取知乎链接：" + url);
			// 根据url获取该问答的细节
			String content = Util.SendGet(url);
			Pattern pattern;
			Matcher matcher;
			// 匹配标题
			pattern = Pattern.compile("zh-question-title.+?<h2.+?>(.+?)</h2>");
			matcher = pattern.matcher(content);
			if (matcher.find()) {
				question = matcher.group(1);
			}
			// 匹配答案
			pattern = Pattern.compile("</noscript><img.+?src=\"(https.+?)\".+?");
			matcher = pattern.matcher(content);
			boolean isFind = matcher.find();
			while (isFind) {
				zhihuPicUrl.add(matcher.group(1));
				isFind = matcher.find();
			}
		}
	}

	// 处理url
	boolean getRealUrl(String url) {
		// 将http://www.zhihu.com/question/22355264/answer/21102139
		// 转化成http://www.zhihu.com/question/22355264
		// 否则不变
		Pattern pattern = Pattern.compile("question/(.*?)");
		Matcher matcher = pattern.matcher(url);
		if (matcher.find()) {
			url = "http://www.zhihu.com/question/" + matcher.group(1);
		} else {
			return false;
		}
		return true;
	}
}
