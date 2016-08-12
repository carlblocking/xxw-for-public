package thread2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.LogRecord;

public class EchoServer {
	private int port=8000;
	private ServerSocket serverSocket;
	private ExecutorService executorService;
	private final int POOL_SIZE=4;
	public EchoServer() throws IOException{
		serverSocket=new ServerSocket(port);
		executorService=Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()*POOL_SIZE);
		System.out.println("·þÎñÆ÷Æô¶¯");
	}
	
	public void service(){
		while (true) {
			Socket socket=null;
			try {
				socket=serverSocket.accept();
				executorService.execute(new Handler(socket));
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new EchoServer().service();
	}

}
