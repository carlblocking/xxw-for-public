package smallAlgorithmDemo;

import java.util.Stack;

/*stackѧϰ*/
public class Function5 {
    static void showpush(Stack<Integer> stack,int i){
	System.out.println("push()->"+i);
	stack.push(i);
    }
    static void showpop(Stack<Integer> stack){
	System.out.println("pop()->"+stack.pop());
    }
    public static void main(String[] args) {
	Stack<Integer> stack=new Stack<Integer>();
	showpush(stack, 1);
	showpush(stack, 2);
	showpush(stack, 3);
	showpop(stack);
	showpop(stack);
	System.out.println(stack.size());
    }

}
