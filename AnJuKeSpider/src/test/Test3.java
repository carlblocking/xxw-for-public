package test;

import java.util.List;

import method.Analysis;
import method.Util;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strings=Util.getUrlList();
		Analysis analysis=new Analysis();
		for (String string:strings) {
			analysis.analysis(string);
		}
	}

}
