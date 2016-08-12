package tool;

public class DealUrl {
	public boolean dealUrl(String url){	
		if(url.startsWith("http://www.zhihu.com/people/")&&count(url))
			return true;
		else {
			return false;
		}
	}
	private boolean count(String url){
		int i=url.length();
		int count=0;
		for (int j = 0; j < i; j++) {
			if (url.charAt(count)=='/') {
				count++;
			}
		}
		if (count==4) {
			return true;
		}
		else {
			return false;
		}
	}
}
