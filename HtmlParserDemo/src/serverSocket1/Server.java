package serverSocket1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private int port=8000;
	private ServerSocket serverSocket;
	public Server() throws IOException{
		serverSocket=new ServerSocket(port,3);
		System.out.println("·þÎñÆ÷Æô¶¯");
	}
	public void service(){
		while (true) {
			Socket socket=null;
			try {
				socket=serverSocket.accept();
				System.out.println("new connection accepted"+socket.getInetAddress()+":"+socket.getPort());
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			finally{
				try {
					if(socket!=null)socket.close();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Server server=new Server();
			//Thread.sleep(36000*60);
			server.service();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
