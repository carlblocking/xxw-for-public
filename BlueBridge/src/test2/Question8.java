package test2;

public class Question8 {
    static int i=100;//µü´ú100´Î
    static void f(double init,double parameter){
	if(i<=0) return;
	init=init*(1-init)*parameter;
	System.out.println(init);
	i--;
	f(init, parameter);
    }
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	double x=0.2;
	double r=3.62;
	f(x, r);
    }

}
