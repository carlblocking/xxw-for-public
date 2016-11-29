package smallAlgorithmDemo2;

import java.util.Arrays;

public class Function1 {
    static void testInteger(){
	int a[]={1,2,3,4,5,6,8,6,12,45,2,7};
	Arrays.sort(a);
	for(int i:a){
	    System.out.print(i+"\t");
	   }
    }
    static void testCharacter(){
	char a[]={'A','B','F','D','C','H'};
	Arrays.sort(a);
	for(char i:a){
	    System.out.print(i+"\t");
	   }
    }
    public static void main(String[] args) {
	testInteger();
	System.out.println();
	testCharacter();
    }

}
