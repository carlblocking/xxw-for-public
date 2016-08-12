package test;

import method.Spider;
import method.Util;
import bean.JobInfo;

public class TestGetInfo {
	public static void main(String[] args) {
		Spider spider=new Spider();
		try {
			spider.getInformation();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
