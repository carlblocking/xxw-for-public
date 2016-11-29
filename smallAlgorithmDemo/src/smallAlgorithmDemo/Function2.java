package smallAlgorithmDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public abstract class Function2 {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	List<String> strings=new ArrayList<String>();
	List<String> strings2=new ArrayList<String>();
	Vector<String> vector=new Vector<String>();
	strings.add("123");
	strings.add("123");
	strings.add("1234");
	strings.add("1234");
	strings.add("12345");
	strings.add("12345");
	//赋值
	for(int i=0;i<strings.size();i++){
	    vector.add(strings.get(i));
	}
	//消除重复项
	for(int i=0;i<vector.size();i++){
	    for(int j=i;j<vector.size();j++){
		if(vector.get(i).equals(vector.get(j))){
		    vector.remove(j);
		}
	    }
	}
	
	//打印
	for(int i=0;i<vector.size();i++){
	    strings2.add(vector.get(i));
	}
    }

}
