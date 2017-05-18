#include<iostream>
#include<string>

using namespace std;

class Window_mgr {
public:
	void clear();
};

class Person {
private:
	string name;
	string address;
public:
	string getName()const { return name; }
	string getAddress()const { return address; }

	istream& read(istream& is, Person& person) {
		is >> person.name >> person.address;
		return is;
	}

	ostream& print(ostream& os, Person& person) {
		os << person.getName() << "\t" << person.getAddress() << endl;
		return os;
	}
public:
	Person() = default;
	Person(const string& name, const string& address) {
		this->name = name;
		this->address = address;
	}
};

class screen {
private:
	unsigned height = 0;
	unsigned width = 0;
	unsigned cursor = 0;
	string contents;
public:
	screen() = default;
	screen(unsigned ht, unsigned wd):height(ht),width(wd),contents(ht*wd,' ') {}
	screen(unsigned ht, unsigned wd,char c) :height(ht), width(wd), contents(ht*wd, c) {}
public:
	friend void Window_mgr::clear();

	screen& move(unsigned r, unsigned c) {
		cursor = width*r + c;
		return *this;
	}

	screen& set(char ch) {
		contents[cursor] = ch;
		return *this;
	}

	screen& set(unsigned r, unsigned c, char ch) {
		contents[r*width + c] = ch;
		return *this;
	}

	screen& display() {
		cout << contents;
		return *this;
	}

	screen& setContent(char ch) {
		contents = ch;
		return *this;
	}

	string getContent() {
		return this->contents;
	}
};

void Window_mgr::clear() {
	screen screen1(10,20,'x');
	cout << "清理前的contents内容是" << endl;
	screen1.display();
	cout << endl;

	screen1.setContent(NULL);
	cout << "清理后的contents内容是" << endl;
	cout << screen1.getContent() << endl;
	cout << "end" << endl;
}

class Tree {
private:
	string Name;
	unsigned Age = 0;
	double height = 0;
public:
	Tree() = default;
	Tree(const string &n, unsigned a, double h) :Name(n), Age(a), height(h) {};
};

class NoDefault {
public:
	int val;
	NoDefault(int item) {
		val = item;
	}
};

class C {
public:
	NoDefault nd;
	C(int item = 0) :nd(item) {};
};

int main2_1() {
	C c(15);
	cout << c.nd.val << endl;
	return 0;
}