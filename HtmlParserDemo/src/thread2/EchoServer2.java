package thread2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 具有关闭服务器功能*/
public class EchoServer2 {
	private int port=8000;
	private ServerSocket serverSocket;
	private ExecutorService executorService;
	private final int POOL_SIZE=4;
	
	private int portForShutdowm=8001;
	private ServerSocket serverSocketForShutdown;
	private boolean IsShutdowm=false;
	
	private Thread shutdowntThread=new Thread(){
		public void start(){
			this.setDaemon(true);
			super.start();
		}
		public void run(){
			while(!IsShutdowm){
				Socket socketForShutdown=null;
				try {
					socketForShutdown=serverSocketForShutdown.accept();
					BufferedReader br=new BufferedReader(
							new InputStreamReader(socketForShutdown.getInputStream()));
					String command=br.readLine();
					if(command.equals("shutdown")){
						long beginTime=System.currentTimeMillis();
						socketForShutdown.getOutputStream().write("服务器正在关闭\r\n".getBytes());
						IsShutdowm=true;
						executorService.shutdown();
						while(!executorService.isTerminated()){
							executorService.awaitTermination(30, TimeUnit.SECONDS);
						}
						serverSocket.close();
						long endTime=System.currentTimeMillis();
						socketForShutdown.getOutputStream().write(("服务器已经关闭，"+
						"关闭服务器用了"+(endTime-beginTime)+"毫秒\r\n").getBytes());
						socketForShutdown.close();serverSocketForShutdown.close();
					}
					else {
						socketForShutdown.getOutputStream().write("错误的命令\r\n".getBytes());
						socketForShutdown.close();
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		}
	};
	
	public EchoServer2() throws IOException{
		serverSocket=new ServerSocket(port);
		serverSocket.setSoTimeout(60000);
		serverSocketForShutdown=new ServerSocket(portForShutdowm);
		executorService=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_SIZE);
		shutdowntThread.start();
		System.out.println("服务器启动");
	}
	
	public void service(){
		while(!IsShutdowm){
			Socket socket=null;
			try {
				socket=serverSocket.accept();
				socket.setSoTimeout(60000);
				executorService.execute(new Handler(socket));
			} catch (SocketTimeoutException e) {
				// TODO: handle exception
			} 
			catch (RejectedExecutionException e) {
				// TODO: handle exception
				try {
					if(socket!=null){
						socket.close();
					}
				} catch (IOException e2) {
					// TODO: handle exception
				}
				return;
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				if(e.getMessage().indexOf("socket closed")!=-1) return;
			}
			catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new EchoServer2().service();
	}

}
