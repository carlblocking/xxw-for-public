package method;

import java.util.ArrayList;
import java.util.List;

public class Util {
	public static List<String> getUrlList(){
		List<String> infoList=new ArrayList<String>();
		try {
			for (int i = 1; i <=50; i++) {
				infoList.add("http://sh.zu.anjuke.com/fangyuan/p"+i+"/");
			}
			return infoList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
