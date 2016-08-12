package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.ZhiHuBean;
import bean.ZhiHuPicBean;
import bean.ZhiHuUserBean;

public class Spider {

	/**
	 * 爬知乎图片，并下载到本地
	 * @throws Exception 
	 */
	public static void downloadPic(String url) throws Exception {
		// 构造方法传url，获取ZhiHuPicBean
		ZhiHuPicBean myZhihu = new ZhiHuPicBean(url);
		// 获取ZhiHuPicBean中的图片列表
		ArrayList<String> picList = myZhihu.getZhihuPicUrl();
		// 打印结果
		System.out.println("");
		System.out.println("标题：" + myZhihu.getQuestion());
		System.out.println("");
		// 循环，在控制台打印图片地址
		for (String zhiHuPic : picList) {
			System.out.println(zhiHuPic);
		}
		System.out.println("");
		//定义下载路径
		String addr = "D:/知乎爬虫/";
		System.out.println("即将开始下载图片到"+addr+myZhihu.getQuestion());
		System.out.println("");
		System.out.println("开始下载................");
		System.out.println("");
		// 把图片下载到本地文件夹
		FileReaderWriter.downLoadPics(myZhihu, addr);
		System.out.println("");
		System.out.println("图片下载完毕，请到"+addr+myZhihu.getQuestion()+"里去看看吧！！！");
	}


	/**
	 * 爬取指定话题下所有精华问题最高得票人的信息
	 * @throws Exception 
	 */
	public static void getTopUserInfo(String url) throws Exception {
		//定义起始页为第一页
		int page = 1;
		//定义baseUrl
		String baseUrl = "https://www.zhihu.com";
		/**
		 * jdbc四大配置参数：
		 * 1.driverClassName:com.mysql.jdbc.Driver
		 * 2.url:jdbc:mysql://localhost:3306/mydb
		 * 3.username:root
		 * 4.password:123
		 */
		Class.forName("com.mysql.jdbc.Driver");//加载驱动类(注册驱动类)
		String mySqlUrl="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
		//String mySqlUrl = "jdbc:mysql://localhost:3306/user_info";
		String username = "root";
		String password = "******";
		
		//得到连接对象
		Connection con = DriverManager.getConnection(mySqlUrl, username, password);
			
		/*对数据库做增、删、改
		 * 1.通过Connection对象创建Statement
		 *   Statement语句的发送器，它的功能就是向数据库发送sql语句！
		 * 2.调用他的int executeUpdate(String sql),返回影响了几行
		 */
		//通过Connection 得到Statement;
		Statement stmt = con.createStatement();
		
		//循环到最后一页，分别爬取每一页的回答中排名第一的用户
		for (page = 1;page<=50;page++){
			// 定义即将访问的链接，起始第一页
			String nowUrl = url+"?page="+page;
			List<String> userUrls = Util.getUserUrl(nowUrl);
			// 循环访问链接并获取用户信息
			for(String userUrl:userUrls){
				//初始化呢赋值
				ZhiHuUserBean user = new ZhiHuUserBean(baseUrl+userUrl);
				//打印当前用户信息
				System.out.println(user);
				//使用Statement发送sql语句
				String sql = "INSERT INTO user(name,location,business,employment,position,education,major,userInfo,answersNum,starsNum,thxNum)"
						+ " VALUES('"+user.getName()+"','"+user.getLocation()+"','"+user.getBusiness()+"','"
						+user.getEmployment()+"','"+user.getPosition()+"','"+user.getEducation()+"','"
						+user.getMajor()+"','"+user.getUserInfo()+"',"+user.getAnswersNum()+","
						+user.getStarsNum()+","+user.getThxNum()+")";
				//执行sql
				stmt.executeUpdate(sql);
				System.out.println("信息存入数据库成功！");
				System.out.println();
			}
		}
	}


	/**
	 * 爬知乎推荐的内容
	 */
	public static void downloadCommend(String url){
		 // 访问链接并获取页面内容
		 String content = Util.SendGet(url);
		 // 获取该页面的所有的知乎对象
		 ArrayList<ZhiHuBean> myZhihu = Util.GetRecommendations(content);
		 for (ZhiHuBean zhihu : myZhihu) {
		 FileReaderWriter.writeIntoFile(zhihu.writeString(),"D:/知乎编辑推荐.txt",true);
		 }
	}
}
