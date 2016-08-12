package test;

public class Business {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account midAccount=new Account();//÷–º‰’Àªß
		Buyer buyer=new Buyer(midAccount, "China", "132@163.com", "Carl", "123");
		Seller seller=new Seller("Seller", "China", "13@qq.com", "456", midAccount);
		Thread accountThread=new Thread(buyer);
		Thread accountThread2=new Thread(seller);
		accountThread.start();
		accountThread2.start();
		System.out.println("Account:start Balance:%f\n"+midAccount.getBalance());
	}

}
