package smallAlgorithmDemo;

import java.util.Scanner;

/*目的：x处以26，整数部分用对应的26字母代替，余数用对应26个字母代替*/
public class Function3 {
    static char[] alphabet={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public static String change(int i){
	String string="";
	int a=i/26;
	int b=i%26;
	string=change2(a)+change2(b);
	return string;
    }
    public static String change2(int i){
	if(i==0)
	    return "";
	else {
	    return String.valueOf(alphabet[i-1]);
	}
    }
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println("请输入一个整数");
	int i=new Scanner(System.in).nextInt();
	System.out.println(change(i));
    }

}
