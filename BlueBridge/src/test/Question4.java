package test;
/*
 * Excel是最常用的办公软件。每个单元格都有唯一的地址表示。比如：第12行第4列表示为：“D12”，第5行第255列表示为“IU5”。9 I 21 U
事实上，Excel提供了两种地址表示方法，还有一种表示法叫做RC格式地址。
第12行第4列表示为：“R12C4”，第5行第255列表示为“R5C255”。
你的任务是：编写程序，实现从RC地址格式到常规地址格式的转换。
【输入、输出格式要求】
用户先输入一个整数n（n<100），表示接下来有n行输入数据。
接着输入的n行数据是RC格式的Excel单元格地址表示法。
程序则输出n行数据，每行是转换后的常规地址表示法。
例如：用户输入：
2
R12C4
R5C255
则程序应该输出：
D12
IU5*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question4 {
    static char[] alphabet={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    static List<String> strings=new ArrayList<String>();
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
    public static String change(String string){
	String string2="";
	//分解字符串
	int a=0;//用来记录'R'的位置
	int b=0;//用来记录'C'的位置
	for(int k=0;k<string.length();k++){
	    if(string.charAt(k)=='R')a=k;
	    if(string.charAt(k)=='C')b=k;
	}
	String s1=string.substring(a+1, b);
	String s2=string.substring(b+1,string.length());
	//int c=Integer.valueOf(s1);
	int d=Integer.valueOf(s2);
	string2=change(d)+s1;
	return string2;
    }
    public static void main(String[] args) {
	//初始化数据
	System.out.println("请输入数据的数目");
	int i=new Scanner(System.in).nextInt();
	System.out.println("请输入"+i+"个数据");
	for(int n=0;n<i;n++){
	    String string=new Scanner(System.in).nextLine();
	    String tmp=change(string);
	    strings.add(tmp);
	}
	
	//打印结果
	for(int j=0;j<strings.size();j++){
	    System.out.println(strings.get(j));
	}
    }

}
