package test;

import java.util.Scanner;
import java.util.Vector;

/*
    在实际的开发工作中，对字符串的处理是最常见的编程任务。
    本题目即是要求程序对用户输入的串进行处理。具体规则如下：
    1.把每个单词的首字母变为大写。
    2.把数字与字母之间用下划线字符（_）分开，使得更清晰
    3.把单词中间有多个空格的调整为1个空格。
    例如：
    用户输入：
    you and     me what  cpp2005program
    则程序输出：
    You And Me What Cpp_2005_program
    用户输入：
    this is     a      99cat
    则程序输出：
    This Is A 99_cat
    我们假设：用户输入的串中只有小写字母，空格和数字，不含其它的字母或符号。
    每个单词间由1个或多个空格分隔。
    假设用户输入的串长度不超过200个字符。
 */
public class Question2 {
    public static void process(String string) {
	Vector<Character> result = new Vector<Character>();
	for (int i = 0; i < string.length(); i++) {
	    result.add(string.charAt(i));
	}

	// 先将所有单词首字母转换为大写
	result.set(0, result.get(0).toUpperCase(result.get(0)));// 字符串第一个字母设置为大写
	for (int i = 1; i < result.size(); i++) {
	    if (result.get(i - 1) == ' ') {
		result.set(i, result.get(i).toUpperCase(result.get(i)));
	    }
	}

	// 处理多余的空格
	int index1 = 0;
	while (index1 <= result.size() - 1) {
	    if (result.elementAt(index1) == ' ' && result.elementAt(index1 + 1) == ' ') {
		result.remove(index1);
		index1--;
	    }
	    index1++;
	}

	// 再在所有数字、字母之间添加‘_’符号
	int index = 0;
	while (index <= result.size() - 1) {
	    // 如果这个字符为数字,就进行判断操作
	    if (result.get(index).isDigit(result.get(index))) {
		if ((result.get(index - 1) >= 'a' && result.get(index - 1) <= 'z')
			|| (result.get(index - 1) >= 'A' && result.get(index - 1) <= 'Z')) {
		    result.add(index, '_');
		    index++;
		}
		if ((result.get(index + 1) >= 'a' && result.get(index + 1) <= 'z')
			|| (result.get(index + 1) >= 'A' && result.get(index + 1) <= 'Z')) {
		    result.add(index + 1, '_');
		    index++;
		}
	    }
	    index++;
	}

	// 输出字符串
	for (int i = 0; i < result.size(); i++) {
	    System.out.print(result.get(i));
	}
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println("请输入一个字符串");
	Scanner scanner = new Scanner(System.in);
	String string = scanner.nextLine();
	process(string);
    }
}
