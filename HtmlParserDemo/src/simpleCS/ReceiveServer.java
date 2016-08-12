package simpleCS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import com.sleepycat.je.rep.monitor.NewMasterEvent;

public class ReceiveServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket=new ServerSocket(8000);
			Socket s=serverSocket.accept();
			InputStream in=s.getInputStream();
			ByteArrayOutputStream buffer=new ByteArrayOutputStream();
			byte[] buff=new byte[1024];
			int len=-1;
			do {
				try {
					len=in.read(buff);
					if(len!=-1)buffer.write(buff,0,len);
				} catch (SocketTimeoutException e) {
					// TODO: handle exception
					System.out.println("µÈ´ý¶Á³¬Ê±");
					len=0;
				}
			} while (len!=-1);
			System.out.println(new String(buffer.toByteArray()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
