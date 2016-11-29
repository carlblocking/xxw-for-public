package test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Question9 {
    static List<String>strings=new ArrayList<String>();
    //ÕÒ³ö×Ö·û´®ÖÐAABAAÀàÐÍµÄ¾µÏñ×Ö·û´®
    static void AABAA(String string){
	for(int i=0;i<string.length()-1;i++){
	    for(int tmp=0;;tmp++){
		if(i-tmp<0||(string.charAt(i-tmp)!=string.charAt(i+tmp))){
		    break;
		}else {
		    String string2=string.substring(i-tmp, i+tmp+1);
		    strings.add(string2);
		}
	    }
	}
    }
    //ÕÒ³ö×Ö·û´®ÖÐAABBÀàÐÍµÄ¾µÏñ×Ö·û´®
    static void AABB(String string){
	for(int i=0;i<string.length()-1;i++){
	    for(int tmp=0;;tmp++){
		if(i-tmp<0||(string.charAt(i-tmp)!=string.charAt(i+tmp+1))){
		    break;
		}else {
		    String string2=string.substring(i-tmp, i+tmp+2);
		    strings.add(string2);
		}
	    }
	}
    }
    //ÅÅÐò
    public static void compare(List<String>strings){
	String tmpstring="";
	for(String string:strings){
	    if(string.length()>tmpstring.length())
		tmpstring=string;
	}
	System.out.println(tmpstring);
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	@SuppressWarnings("resource")
	String string=new Scanner(System.in).nextLine();
	AABB(string);
	AABAA(string);
	compare(strings);
    }

}
