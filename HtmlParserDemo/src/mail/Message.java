package mail;

public class Message {
	String from;
	String to;
	String subject;
	String content;
	String data;
	public Message(String from,String to,String subject,String content){
		this.content=content;
		this.from=from;
		this.subject=subject;
		this.to=to;
		data="Subject:"+subject+"\r\n"+content;
	}
}
