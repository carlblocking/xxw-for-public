package smallAlgorithmDemo2;
/*所有3位数中的水仙花数*/
public class Funtion2 {
    static boolean isShuiXian(int i){
	String string=String.valueOf(i);
	char[] tmp=string.toCharArray();
	int a[]=new int[3];
	for(int j=0;j<3;j++){
	    a[j]=tmp[j]-'0';
	}
	if(i==(a[0]*a[0]*a[0]+a[1]*a[1]*a[1]+a[2]*a[2]*a[2]))
	    return true;
	else
	    return false;
    }
    public static void main(String[] args) {
	for(int i=100;i<=999;i++){
	    if(isShuiXian(i))
		System.out.println(i);
	}
    }

}
