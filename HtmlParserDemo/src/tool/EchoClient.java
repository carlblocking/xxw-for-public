package tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.time.Period;

public class EchoClient {
	private String host="localhost";
	private int port=8081;
	private Socket socket;
	public EchoClient() throws IOException{
		socket=new Socket(host, port);		
	}
	
	public static PrintWriter getWriter(Socket socket) throws IOException{
		OutputStream socketOut=socket.getOutputStream();
		return new PrintWriter(socketOut,true);
	}
	
	private BufferedReader getReader(Socket socket) throws IOException{
		InputStream socketIn=socket.getInputStream();
		return new BufferedReader(new InputStreamReader(socketIn));
	}
	
	public void talk() throws IOException{
		try {
			BufferedReader br=getReader(socket);
			PrintWriter pw=getWriter(socket);
			BufferedReader localReader=new BufferedReader(new InputStreamReader(System.in));
			String message=null;
			while ((message=localReader.readLine())!=null) {
				pw.println(message);
				System.out.println(br.readLine());
				if(message.equals("bye"))
					break;
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				socket.close();
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new EchoClient().talk();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
