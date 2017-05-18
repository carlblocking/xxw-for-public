#include<iostream>
#include<vector>
#include<string>

using namespace std;

void print(string s) {
	cout << s << endl;
}

void println() {
	cout << endl;
}

struct X
{
	X() { cout << "构造函数X()" << endl; }
	X(const X&) { cout << "构造函数X(const X&)" << endl; }
	X& operator=(const X& rhs) { 
		cout << "拷贝赋值运算符(const X& rhs)" << endl;
		return *this; 
	}
	~X() {
		cout << "析构函数~X()" << endl;
	}
};

void f1(X x) {}

void f2(X& x) {}

int main13_1() {
	print("局部变量");
	X x;
	println();

	print("非引用参数传递");
	f1(x);
	println();

	print("引用参数传递");
	f2(x);
	println();

	print("动态分配");
	X* px = new X;
	println();

	print("添加到容器中");
	vector<X> vx;
	vx.push_back(x);
	println();

	print("释放动态分配对象");
	delete px;
	println();

	print("间接初始化和赋值");
	X y = x;
	y = x;
	println();

	print("程序结束");

	return 0;
}