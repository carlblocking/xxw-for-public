package test;

import method.*;


/**
 * 主函数
 * 功能1：抓取知乎指定问题下的图片并下载 
 * 功能2：爬取知乎指定话题下所有精华问题最高得票人的所有信息，并输入到本地数据库
 * 功能3：抓取知乎推荐内容并写入本地
 * 选用任意一个方法，只需将url匹配到当前方法就行
 * 
 * @author KKys
 *
 */
public class ZhiHuMain {

	public static void main(String[] args) throws Exception {
		
		//定义你要抓取页面的url，格式参照下文
		//当前url对应方法一
		//String url = "https://www.zhihu.com/question/28594126";
		String url="https://www.zhihu.com/topic/19601705/top-answers";
		/*
		 * 方法一：抓取知乎图片，并下载到本地文件夹
		 * 下载地址在Spider.downloadPic中修改
		 * url型如"https://www.zhihu.com/question/28594126";
		 */
		//Spider.downloadPic(url);
		
		
		/*
		 * 方法二：爬取指定话题下所有精华问题最高得票人的信息，并输入到本地数据库
		 * 数据库信息在Spider.getTopUserInfo中修改
		 * url型如"https://www.zhihu.com/topic/19570261/top-answers"
		 */
		Spider.getTopUserInfo(url);
		
		
		/*
		 * 方法三：爬知乎推荐的内容，到本地txt文件
		 * 下载地址在Spider.downloadCommend中修改
		 * url:"https://www.zhihu.com/explore/recommendations"
		 */
//		Spider.downloadCommend(url);
	}
}

