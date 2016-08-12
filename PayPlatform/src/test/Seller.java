package test;

public class Seller implements Runnable {
	private String name;
    private String address;
    private String email;
    private String phone;
    private Account account;

    //构造方法
    public Seller(String name, String address, String email, String phone,Account account)
    {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.account= account;
    }

    //打印用户信息（基本信息+用户名下账户）
    public void printCustomerInfo()
    {
        System.out.println(" Information about a customer");
        System.out.println(" Name                - " + name);
        System.out.println(" address             - " + address);
        System.out.println(" email               - " + email);
        System.out.println(" phone #             - " + phone);
        if(account != null){
            account.printInfo(); 
        }
        else{
            System.out.println("The customer has no accounts");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <10; i++) {
			account.withdraw(1000);
			System.out.println("The Balance of account after No:"+i +"withdraw is :"+account.getBalance());
		}
	}

}
