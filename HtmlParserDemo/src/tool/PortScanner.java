package tool;

import java.io.IOException;
import java.net.Socket;

public class PortScanner {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host="localhost";
/*		if (args.length>0) {
			host=args[0];
		}*/
		new PortScanner().scan(host);
	}
	public void scan(String hosts){
		Socket socket=null;
		for (int port = 1000; port < 1024; port++) {
			try {
				socket=new Socket(hosts, port);
				System.out.println("There is a server on port"+port);
			} catch (IOException e) {
				System.out.println("can't connect to port:"+port);
				// TODO: handle exception
			}
			finally{
				try {
					if(socket!=null)
						socket.close();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
	}
}
