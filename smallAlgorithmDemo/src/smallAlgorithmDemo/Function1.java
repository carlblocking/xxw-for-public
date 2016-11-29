package smallAlgorithmDemo;

import java.util.Scanner;
import java.util.Vector;

/*用于消除字符串中的多余空格*/
/*test string:This is     a       cat and    hello*/
public class Function1 {
    public static void RemoveNull(String string){
	Vector<Character> vector=new Vector<Character>();
	for(int i=0;i<string.length();i++){
	    vector.add(string.charAt(i));
	}
	int index=0;
	for(int j=0;j<vector.size();j++){
	    System.out.print(vector.elementAt(j));
	}
	System.out.println();

	while (index <= vector.size() - 1) {
	    if (vector.elementAt(index) == ' ' && vector.elementAt(index + 1) == ' ') {
		vector.remove(index);
		index--;
	    }else{ index++;}
	}
	    
	for(int j=0;j<vector.size();j++){
	    System.out.print(vector.elementAt(j));
	}
    }
    public static void main(String[] args) {
	System.out.println("请输入一个字符串");
	String string=new Scanner(System.in).nextLine();
	RemoveNull(string);
    }
}
