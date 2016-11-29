package test;
/*算法是这样的，如果给定N个不同字符，将这N个字符全排列，最终的结果将会是N!种。
 * 如：给定 A、B、C三个不同的字符，则结果为：
 * ABC、ACB、BAC、BCA、CAB、CBA一共3!=3*2=6种情况。
 * 参考思路：http://blog.csdn.net/lemon_tree12138/article/details/50986990
 * */
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
	String str = "";
	System.out.println("请输入一个没有相同元素的字符串：");
	Scanner scan = new Scanner(System.in);
	str = scan.nextLine();
	permutation(str.toCharArray(), 0,str.length()-1);
    }

    public static void permutation(char[] str, int cursor,int end) {
	if(cursor==end){
	    System.out.println(String.valueOf(str));
	}else{
	    for(int i=cursor;i<=end;i++){
		char tmp;
		tmp=str[cursor];
		str[cursor]=str[i];
		str[i]=tmp;
		permutation(str, cursor+1, end);
	    }
	}
    }
}
