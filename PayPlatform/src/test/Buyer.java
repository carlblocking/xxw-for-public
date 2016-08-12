package test;

public class Buyer implements Runnable {
	private String name;
	private String address;
	private String email;
	private String phone;
	private Account account;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	public Buyer(Account account,String address,String email,String name,String phone){
		this.account=account;
		this.address=address;
		this.email=email;
		this.phone=phone;
		this.name=name;
	}
	public void printCustomerInfo(){
		System.out.println("Information about a buyer");
		System.out.println("name:\t"+name);
		System.out.println("address:\t"+address);
		System.out.println("email:\t"+email);
		System.out.println("phone:\t"+phone);
		if(account!=null){
			account.printInfo();
		}
		else {
			System.out.println("This buyer has no account");
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <10; i++) {
			account.deposit(1000);
			System.out.println("The rest of account after No. "+i+"deposit is"
					+account.getBalance());
		}
	}

}
