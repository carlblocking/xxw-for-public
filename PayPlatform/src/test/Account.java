package test;

public class Account {
	private double balance;

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public  Account() {
		balance=0;
	}
	/**
	 * 付款，此处有synchronized修饰
	 */
	public synchronized void deposit(double amount){
		double tmp=balance;
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		tmp+=amount;
		balance=tmp;
	}
	/**
	 * 取款，此处有synchronized修饰*/
	public synchronized void withdraw(double amount){
		double tmp=balance;
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		tmp-=amount;
		balance=tmp;
	}
	/**打印信息*/
	public void printInfo(){
		System.out.println("Balance on account="+balance);
	}
}
