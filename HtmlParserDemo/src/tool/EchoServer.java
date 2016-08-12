package tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private int port=8081;
	private ServerSocket serverSocket;
	public EchoServer() throws IOException{
		serverSocket=new ServerSocket(port);
		System.out.println("server start...");
	}
	
	public String echo(String message){
		return "echo:"+message;
	}
	
	private PrintWriter getWriter(Socket socket)throws IOException{
		OutputStream socketOut=socket.getOutputStream();
		return new PrintWriter(socketOut,true);
	}
	
	private BufferedReader getReader(Socket socket) throws IOException{
		InputStream socketIn=socket.getInputStream();
		return new BufferedReader(new InputStreamReader(socketIn));
	}
	
	public void service(){
		while (true) {
			Socket socket=null;
			try {
				socket=serverSocket.accept();
				System.out.println("New connection accepted"
						+socket.getInetAddress()+ ":"+socket.getPort());
				BufferedReader bufferedReader=getReader(socket);
				PrintWriter pw=getWriter(socket);
				String message=null;
				while ((message=bufferedReader.readLine())!=null) {
					System.out.println(message);
					pw.println(echo(message));
					if(message.equals("bye")){
						break;
					}
				}
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
			new EchoServer().service();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
