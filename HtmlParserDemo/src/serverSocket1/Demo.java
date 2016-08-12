package serverSocket1;

import java.io.IOException;
import java.net.ServerSocket;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket=new ServerSocket(0);
			for (int i = 0; i < 3; i++) {
				System.out.println(serverSocket.getLocalPort());
				serverSocket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
