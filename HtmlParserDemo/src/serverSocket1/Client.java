package serverSocket1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int length=100;
		String host="localhost";
		int port=8000;
		Socket[] sockets=new Socket[length];
		for (int i = 0; i < length; i++) {
			try {
				sockets[i]=new Socket(host,port);
				System.out.println("第"+i+"次连接成功了");
				Thread.sleep(3000);
				for (int j = 0; j < length; j++) {
					sockets[j].close();
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
