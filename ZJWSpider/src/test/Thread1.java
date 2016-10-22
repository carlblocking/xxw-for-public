package test;

import java.util.List;

import method.Analysis;
import method.InfoSource;

public class Thread1 implements Runnable {

	@Override
	public void run() {
		List<String> strings=InfoSource.getUrlList1();
		// TODO Auto-generated method stub
		Thread currenThread=Thread.currentThread();
		synchronized (currenThread) {
			for (String string:strings) {
				new Analysis().analysis1(string);
				currenThread.notify();
			}
		}
	}

}
