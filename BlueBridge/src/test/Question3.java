package test;
/*
 * 看下面的算式：
□□ x □□ = □□ x □□□
它表示：两个两位数相乘等于一个两位数乘以一个三位数。
如果没有限定条件，这样的例子很多。
但目前的限定是：这9个方块，表示1~9的9个数字，不包含0。
该算式中1至9的每个数字出现且只出现一次！
比如：
46 x 79 = 23 x 158
54 x 69 = 27 x 138
54 x 93 = 27 x 186
.....
请编程，输出所有可能的情况！
注意：
左边的两个乘数交换算同一方案，不要重复输出！
不同方案的输出顺序不重要*/
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Question3 {
    static List<String> strings1=new ArrayList<String>();//用于存储所有满足要求的全排列
    static Vector<String> vector=new Vector<String>();//存储最终满足要求的全排列
    static List<String> strings2=new ArrayList<String>();//存储消重后的结果
    //生成所有的全排列，并将满足要求的全排列存入string1
    public static void generateAllSorts(char[] root,int index){
	if (index == 8) {
	    String string = String.valueOf(root);
	    if(yes(string))
		strings1.add(string);
	} else {
	    for (int i = index; i <=8; i++) {
		char tmp = root[index];
		root[index] = root[i];
		root[i] = tmp;
		generateAllSorts(root, index + 1);
	    }
	}
    }
    //判断每个全排列是否满足要求
    public static boolean yes(String string){
	String s1=string.substring(0, 2);
	String s2=string.substring(2, 4);
	String s3=string.substring(4, 6);
	String s4=string.substring(6, 9);
	int a=Integer.valueOf(s1);
	int b=Integer.valueOf(s2);
	int c=Integer.valueOf(s3);
	int d=Integer.valueOf(s4);
	if(a*b==c*d)
	    return true;
	else {
	    return false;
	}
    }
    //消除满足要求的全排列中，左边两值交换的情况
    public static void removeDouble() {
	// 赋值
	for (int i = 0; i < strings1.size(); i++) {
	    vector.add(strings1.get(i));
	}
	// 消除重复项
	for (int i = 0; i < vector.size(); i++) {
	    for (int j = i; j < vector.size(); j++) {
		if (vector.get(i).equals(vector.get(j))) {
		    vector.remove(j);
		}
	    }
	}

	// 赋值string2
	for (int i = 0; i < vector.size(); i++) {
	    strings2.add(vector.get(i));
	}
    }
    public static void main(String[] args) {
	char[] roots={'1','2','3','4','5','6','7','8','9'};
	// TODO Auto-generated method stub
	//生成所有满足要求的字符串
	generateAllSorts(roots, 0);

	//消重
	removeDouble();
	
	//打印
	for(String string:strings2){
	    System.out.println(string);
	}
    }
}
