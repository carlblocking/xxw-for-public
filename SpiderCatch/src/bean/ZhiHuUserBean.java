package bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import method.*;
/**
 * 知乎用户bean
 * 
 * @author KKys
 *
 */

public class ZhiHuUserBean {

	String name;// 用户姓名
	
	String location;// 居住地;
	
	String business;// 行业
	
	String employment;// 公司
	
	String position;// 职位;
	
	String education;// 大学
	
	String major;// 专业
	
	String userInfo;// 个人简介
	
	int answersNum;// 回答数量
	
	Long starsNum;// 被赞同数
	
	Long thxNum;// 被感谢数

	// 构造方法初始化数据
	public ZhiHuUserBean(String url) {
		//初始化为空字符串
		name = "";
		location = "";
		business = "";
		employment = "";
		position = "";
		education = "";
		major = "";
		userInfo = "";
		System.out.println("正在抓取用户链接：" + url);
		// 根据url获取该用户的详细资料
		String content = Util.SendGet(url);
		Pattern pattern;
		Matcher matcher;
		// 匹配姓名
		pattern = Pattern.compile("class=\"name\">(.+?)</span>");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			name = matcher.group(1);
		}
		// 匹配居住地
		pattern = Pattern.compile("location item.+?title=\"(.+?)\"");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			location = matcher.group(1);
		}
		// 匹配行业
		pattern = Pattern.compile("business item.+?title=\"(.+?)\"");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			business = matcher.group(1);
		}
		// 匹配公司
		pattern = Pattern.compile("employment item.+?title=\"(.+?)\"");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			employment = matcher.group(1);
		}
		// 匹配职位
		pattern = Pattern.compile("position item.+?title=\"(.+?)\"");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			position = matcher.group(1);
		}
		// 匹配大学
		pattern = Pattern.compile("education item.+?title=\"(.+?)\"");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			education = matcher.group(1);
		}
		// 匹配专业
		pattern = Pattern.compile("education-extra item.+?title=\"(.+?)\"");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			major = matcher.group(1);
		}
		// 匹配个人简介
		pattern = Pattern.compile("fold-item.+?content\">(.*?)</span>");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			userInfo = matcher.group(1).replaceAll("<.*?>", "");;
		}
		// 匹配回答数量
		pattern = Pattern.compile("answers\">.+?>(.*?)</span>");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			answersNum = Integer.parseInt(matcher.group(1));
		}
		// 匹配被赞数
		pattern = Pattern.compile("zm-profile-header-user-agree.+?strong>(.*?)</strong>");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			starsNum = Long.parseLong(matcher.group(1));
		}
		// 匹配被感谢数
		pattern = Pattern.compile("zm-profile-header-user-thanks.+?strong>(.*?)</strong>");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			thxNum = Long.parseLong(matcher.group(1));
		}
	}

	@Override
	public String toString() {
		return "姓名：" + name + "\n" + "居住地：" + location + "\n" + "行业：" + business + "\n公司：" + employment
				+ "\n职位："+ position + "\n大学："+ education + "\n专业："+ major + 
				"\n个人简介："+ userInfo + "\n回答数：" + answersNum+"\n被点赞数："+ starsNum+"\n被收藏数："+ thxNum;
	}
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getBusiness() {
		return business;
	}



	public void setBusiness(String business) {
		this.business = business;
	}



	public String getEmployment() {
		return employment;
	}



	public void setEmployment(String employment) {
		this.employment = employment;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public String getEducation() {
		return education;
	}



	public void setEducation(String education) {
		this.education = education;
	}



	public String getMajor() {
		return major;
	}



	public void setMajor(String major) {
		this.major = major;
	}


	public int getAnswersNum() {
		return answersNum;
	}



	public void setAnswersNum(int answersNum) {
		this.answersNum = answersNum;
	}



	public Long getStarsNum() {
		return starsNum;
	}



	public void setStarsNum(Long starsNum) {
		this.starsNum = starsNum;
	}



	public Long getThxNum() {
		return thxNum;
	}



	public void setThxNum(Long thxNum) {
		this.thxNum = thxNum;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	
	
}

