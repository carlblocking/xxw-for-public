package tool;

import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class ConnectTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host="localhost";
		int port=25;
		if (args.length>1) {
			host=args[0];
			port=Integer.parseInt(args[1]);
		}
		new ConnectTester().connect(host, port);
	}
	public void connect(String host,int port){
		SocketAddress remoteAdd=new InetSocketAddress(host,port);
		Socket socket=null;
		String result="";
		try {
			long begin=System.currentTimeMillis();
			socket=new Socket();
			socket.connect(remoteAdd,1000);//超时时间设置为1秒
			long end=System.currentTimeMillis();
			result=(end-begin)+"ms";
		} catch (BindException e) {
			// TODO: handle exception
			result="local address and post can't be binded";
		}
		catch (UnknownHostException e) {
			// TODO: handle exception
			result="UnknownHostException";
		}
		catch (ConnectException e) {
			// TODO: handle exception
			result="ConnectException";
		}
		catch (SocketTimeoutException e) {
			// TODO: handle exception
			result="SocketTimeoutException";
		}
		catch (IOException e) {
			// TODO: handle exception
			result="IOException";
		}
		finally{
			try {
				if(socket!=null)socket.close();
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		System.out.println(result);
	}
}
