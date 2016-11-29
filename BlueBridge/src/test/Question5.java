package test;
/*
这个程序的目的就是：根据给定的手机尾号（4位），按照一定的规则来打分。其规则如下：
1. 如果出现连号，不管升序还是降序，都加5分。例如：5678,4321都满足加分标准。
2. 前三个数字相同，或后三个数字相同，都加3分。例如：4888,6665,7777都满足加分的标准。
注意：7777因为满足这条标准两次，所以这条规则给它加了6分。
3. 符合AABB或者ABAB模式的加1分。例如：2255,3939,7777都符合这个模式，所以都被加分。
注意：7777因为满足这条标准两次，所以这条标准给它加了2分。
4. 含有：6，8，9中任何一个数字，每出现一次加1分。例如4326,6875,9918都符合加分标准。其中，6875被加2分；9918被加3分。
尾号最终得分就是每条标准的加分总和！
要求程序从标准输入接收数据，在标准输出上输出结果。
输入格式为：第一行是一个整数n（<100），表示下边有多少输入行，接下来是n行4位一组的数据，就是等待计算加分的手机尾号。
例如，输入：
14
3045
….
…..
6789
8866
则输出：
0
0
….
…
8
5
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question5 {
    //判断是否连续
    public static boolean ctn1(char s[]) {
	char tmp[]=new char[4];
	for(int i=0;i<4;i++){tmp[i]=(char) (s[0]+i);}
	String s1=String.valueOf(s);
	String s2=String.valueOf(tmp);
	if(s1.equals(s2))
	    return true;
	else
	    return false;
    }
    public static boolean ctn2(char s[]) {
	char tmp[]=new char[4];
	for(int i=0;i<4;i++){tmp[i]=(char) (s[0]-i);}
	String s1=String.valueOf(s);
	String s2=String.valueOf(tmp);
	if(s1.equals(s2))
	    return true;
	else
	    return false;
    }
    //处理连号
    public static int LianHao(String string){
	int i=0;
	char s[]=new char[4];
	for(int j=0;j<4;j++)
	    s[j]=string.charAt(j);
	if(ctn1(s)||ctn2(s))
	    i=i+5;
	return i;
    }
    
    //判断前3个相同
    public static boolean qiansan(String string) {
	String string2=string.substring(0,3);
	int i=0;
	if(string2.charAt(i)==string2.charAt(i+1)&&string2.charAt(i)==string2.charAt(i+2))
	    return true;
	else
	    return false;
    }
    //判断后3个相同
    public static boolean housan(String string){
	String string2=string.substring(1,4);
	int i=0;
	if(string2.charAt(i)==string2.charAt(i+1)&&string2.charAt(i)==string2.charAt(i+2))
	    return true;
	else
	    return false;
    }
    //选项二是否满足
    public static int sansan(String string){
	int i=0;
	if(qiansan(string))
	    i=i+3;
	if(housan(string))
	    i=i+3;
	return i;
    }
    //处理AABB/ABAB的形式
    public static boolean isAABB(String string){
	if ((string.charAt(0)==string.charAt(1))&&(string.charAt(2)==string.charAt(3))) {
	    return true;
	}else {
	    return false;
	}
    }

    public static boolean isABAB(String string) {
	if ((string.charAt(0) == string.charAt(2)) && (string.charAt(1) == string.charAt(3))) {
	    return true;
	} else {
	    return false;
	}
    }
    public static int isAABBorABAB(String string){
	int i=0;
	if(isAABB(string))
	    i=i+1;
	if (isABAB(string)) 
	    i=i+1;
	return i;
    }
    //统计6、8、9的出现次数
    public static int a6(String string) {
	int i=0;
	for(int s=0;s<4;s++){
	    if(string.charAt(s)=='6')
		i++;
	}
	return i;
    }
    public static int a8(String string) {
	int i=0;
	for(int s=0;s<4;s++){
	    if(string.charAt(s)=='8')
		i++;
	}
	return i;
    }
    public static int a9(String string) {
	int i=0;
	for(int s=0;s<4;s++){
	    if(string.charAt(s)=='9')
		i++;
	}
	return i;
    }
    public static int  a689(String string) {
	return a6(string)+a8(string)+a9(string);
    }
    public static void main(String[] args) {
	//输入要处理的字符串（收集尾号4位）
	int i=new Scanner(System.in).nextInt();
	List<String> strings=new ArrayList<String>();
	while (i>0) {
	    //System.out.println(i);
	    String string=new Scanner(System.in).nextLine();
	    strings.add(string);
	    i--;
	}
	for(String string:strings){
	    int k=LianHao(string)+sansan(string)+isAABBorABAB(string)+a689(string);
	    System.out.println(k);
	}
    }

}
