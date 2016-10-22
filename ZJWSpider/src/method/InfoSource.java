package method;

import java.util.ArrayList;
import java.util.List;

public class InfoSource {
	//八项规定的链接
	public static List<String> getUrlList1(){
		List<String> infoList=new ArrayList<String>();
		try {
			for (int i = 1; i <=99; i++) {
				infoList.add("http://www.ccdi.gov.cn/special/jdbg3/qb_bgt/fjbxgdwt_jdbg3/index_"+i+".html");
			}
			infoList.add("http://www.ccdi.gov.cn/special/jdbg3/qb_bgt/fjbxgdwt_jdbg3/index.html");
			return infoList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	//不正之风的链接
	public static List<String> getUrlList2(){
		List<String> infoList=new ArrayList<String>();
		try {
			for (int i = 1; i <=53; i++) {
				infoList.add("http://www.ccdi.gov.cn/special/jdbg3/qb_bgt/sffbwt_jdbg3/index_"+i+".html");
			}
			infoList.add("http://www.ccdi.gov.cn/special/jdbg3/qb_bgt/sffbwt_jdbg3/index.html");
			return infoList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
