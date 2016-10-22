package test;

import java.util.List;

import method.Analysis;
import method.InfoSource;

public class Thread2 implements Runnable {

	@Override
	public void run() {
		List<String> strings=InfoSource.getUrlList2();
		// TODO Auto-generated method stub
		Thread currentThread=Thread.currentThread();
		synchronized (currentThread) {
			while ("t1".equals(currentThread.getName())) {
				try {
					currentThread.wait(0);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			for (String string:strings) {
				new Analysis().analysis2(string);
			}
		}
	}

}
