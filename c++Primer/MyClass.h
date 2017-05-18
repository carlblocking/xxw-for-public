#ifndef MYCLASS_H
#define MYCLASS_H
#include<iostream>
using namespace std;
class MyClass {
private:
	int data;
public:
	MyClass(int data) { this->data = data; }
	void getData() {
		cout << this->data << endl;
	}
};
#endif MYCLASS_H
