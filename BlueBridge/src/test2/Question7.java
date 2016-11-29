package test2;

import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {  
	double n=2;//试图求平方根的数字
	double a=0;//结果
	double b=2;//猜想的平方根
	while(Math.abs(a-b)>1E-5){
	    a=(a+b)/2;
	    b=n/a;
	}
	System.out.println(a);
    } 
 
}
