package tool;

import java.io.IOException;
import java.net.ServerSocket;

public class SimpleServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket=new ServerSocket(8000,2);//监听8000端口，设置队列长度为2
			Thread.sleep(360000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
