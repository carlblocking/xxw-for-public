package tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EchoPlayer {
	public String echo(String message){
		return "echo:"+message;
	}
	public void talk() throws IOException{
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		String message=null;
		while ((message=bufferedReader.readLine())!=null) {
			System.out.println(echo(message));
			if(message.equals("bye"))
				break;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new EchoPlayer().talk();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
