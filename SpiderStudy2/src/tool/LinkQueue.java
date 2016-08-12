package tool;

import java.util.HashSet;
import java.util.Set;

public class LinkQueue {
	//已访问的url集合
	private static Set visitedUrl=new HashSet();//用hash表的方式存储
	//待访问的url集合
	private static Queue unVisitedUrl=new Queue();
	//获得url队列
	private static Queue getUnVisitedUrl(){
		return unVisitedUrl;
	}
	//添加到访问的url队列中
	public static void addVisitedUrl(String url){
		visitedUrl.add(url);
	}
	//移除访问过的url
	public static void removeVisitedUrl(String url){
		visitedUrl.remove(url);
	}
	//未访问的url出队列
	public static Object unVisitedUrlDeQueue(){
		return unVisitedUrl.deQueue();
	}
	//保证每url只被访问一次
	public static void addUnvisitedUrl(String url){
		if(url!=null&!url.trim().equals("")
				&&!visitedUrl.contains(url)
				&&!unVisitedUrl.contains(url)){
			unVisitedUrl.enQueue(url);
		}
	}
	//获得已经访问的url数目
	public static int getVisitedUrlNum(){
		return visitedUrl.size();
	}
	//判断未访问的url队列是否为空
	public static boolean unVisitedUrlIsEmpty(){
		return unVisitedUrl.empty();
	}
}
