package bean;

public class BuZhengZhiFeng {
	private String title;
	private String time;
	public BuZhengZhiFeng(String title,String time){
		this.title=title;
		this.time=time;
	}
	public void printInfo() {
		System.out.println(title);
		System.out.println(time);
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
}
