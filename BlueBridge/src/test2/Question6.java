package test2;
/*
 * 下面的代码用于判断一个串中的括号是否匹配所谓匹配是指不同类型的括号必须左右呼应，可以相互包含，但不能交叉
例如：
..(..[..]..)..  是允许的
..(...[...)....].... 是禁止的
对于 main 方法中的测试用例，应该输出：
false
true
false
false*/
import java.util.Stack;

public class Question6 {
    static boolean isGoodBracket(String string){
	Stack<Character> stack=new Stack<Character>();
	for(int i=0;i<string.length();i++){
	    char tmp=string.charAt(i);
	    if(tmp=='(')
		stack.push(')');
	    if(tmp=='[')
		stack.push(']');
	    if(tmp=='{')
		stack.push('}');
	    if(tmp==')'||tmp==']'||tmp=='}'){
		if(stack.size()==0)
		    return false;
		if(stack.pop()!=tmp)
		    return false;
	    }
	}
	if(stack.size()!=0)
	    return false;
	return true;
    }
    public static void main(String[] args) {
	System.out.println(isGoodBracket("...(..[.)..].{.(..).}..."));
	System.out.println(isGoodBracket("...(..[...].(.).).{.(..).}..."));
	System.out.println(isGoodBracket(".....[...].(.).){.(..).}..."));
	System.out.println(isGoodBracket("...(..[...].(.).){.(..)...."));
    }
}
