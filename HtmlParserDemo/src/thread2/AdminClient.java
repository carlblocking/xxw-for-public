package thread2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class AdminClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket=null;
		try {
			socket=new Socket("localhost",8001);
			OutputStream socketOut=socket.getOutputStream();
			socketOut.write("shutdown\r\n".getBytes());
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg=null;
			while ((msg=br.readLine())!=null) {
				System.out.println(msg);
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			try {
				if(socket!=null)socket.close();
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}
