package mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class MailSender {
/*	163.com:
	POP3服务器地址:pop.163.com
	SMTP服务器地址:smtp.163.com*/
	private String smtpServer="smtp.163.com";
	private int port=25;
	private PrintWriter getWriter(Socket socket)throws IOException{
		OutputStream socketOut=socket.getOutputStream();
		return new PrintWriter(socketOut,true);
	}
	private BufferedReader getReader(Socket socket) throws IOException{
		InputStream socketIn=socket.getInputStream();
		return new BufferedReader(new InputStreamReader(socketIn));
	}
	public void sendAndReceive(String str,BufferedReader br,PrintWriter pw)throws IOException{
		if (str!=null) {
			System.out.println("Client>"+str);
			pw.println(str);
		}
		String response;
		if((response=br.readLine())!=null){
			System.out.println("Server>"+response);
		}
	}
	public void sendMain(Message message){
		Socket socket=null;
		try {
			socket=new Socket(smtpServer,port);
			BufferedReader br=getReader(socket);
			PrintWriter pw=getWriter(socket);
			String localhost=InetAddress.getLocalHost().getHostName();
			sendAndReceive(null, br, pw);
			sendAndReceive("HELO"+localhost, br, pw);
			sendAndReceive("Mail from:<"+message.from+">",br , pw);
			pw.println(message.data);
			System.out.println("Client>"+message.data);
			sendAndReceive(".", br, pw);
			sendAndReceive("QIUT", br, pw);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				if (socket!=null) {
					socket.close();
				}
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message message=new Message("1311905780@qq.com", "xxw199423@hotmail.com", "Hello", "I love you");
		new MailSender().sendMain(message);
	}

}
