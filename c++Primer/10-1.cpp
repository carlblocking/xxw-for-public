#include<iostream>
#include<vector>
#include<ctime>
#include<algorithm>
#include<fstream>
#include<list>
#include<string>
#include<iterator>

using namespace std;

void useCount() {
	srand(time(0));
	vector<int> vInt;
	int i;
	cout << "输入向量大小" << endl;
	cin >> i;
	for (int k = 0; k < i; k++) {
		int tmp = rand() % 100;
		vInt.push_back(tmp);
	}
	cout << "生成的向量元素为" << endl;
	for (auto item : vInt) {
		cout << item << "\t";
	}
	cout << endl;

	int find, times;
	cout << "输入你想找的数字" << endl;
	cin >> find;
	times = count(vInt.begin(), vInt.end(), find);
	cout << "数字:" << find << "的出现次数为:" << times << "次" << endl;
}

void useAccumulate() {
	srand(time(0));
	vector<int> vInt;
	int i;
	int sum = 0;
	cout << "输入向量大小" << endl;
	cin >> i;
	for (int k = 0; k < i; k++) {
		int tmp = rand() % 100;
		vInt.push_back(tmp);
	}
	cout << "生成的向量元素为" << endl;
	for (auto item : vInt) {
		cout << item << "\t";
		sum += item;
	}
	cout << endl;

	cout << "向量中所有元素的和为：" << sum << endl;
}

void use_fill_in() {
	srand(time(0));
	vector<int> vInt;
	int i;
	cout << "输入向量大小" << endl;
	cin >> i;
	for (int k = 0; k < i; k++) {
		int tmp = rand() % 100;
		vInt.push_back(tmp);
	}
	cout << "生成的向量元素为" << endl;
	for (auto item : vInt) {
		cout << item << "\t";
	}
	cout << endl;

	fill_n(vInt.begin(),vInt.size(),0);

	cout << "重新设置后的向量元素为" << endl;
	for (auto item : vInt) {
		cout << item << "\t";
	}
	cout << endl;

}


//使用partition函数
bool five_or_more(const string& s1) {
	return s1.size() >= 5;
}
void usePartition() {
	vector<string> sString;
	string s;
	while (getline(cin,s))
	{
		sString.push_back(s);
	}

	for (auto item:sString) {
		cout << item << "\t";
	}
	cout << endl;

	auto iter = partition(sString.begin(),sString.end(),five_or_more);
	for (auto it = sString.begin(); it != iter;it++) {
		cout << *it << endl;
	}
}

void simpleLambda1(int sa) {
	auto sum = [](int a, int b) {return a + b; };
	cout << sum(1,5) << endl;

	auto sum2 = [sa](int b) {return sa + b; };
	cout << sum2(5) << endl;
}

void use_Unique_and_Erase() {
	srand(time(0));
	vector<int> vInt;
	int i;
	cout << "输入向量大小" << endl;
	cin >> i;
	for (int k = 0; k < i; k++) {
		int tmp = rand() % 100;
		vInt.push_back(tmp);
	}
	cout << "生成的向量元素为" << endl;
	for (auto item : vInt) {
		cout << item << "\t";
	}
	cout << endl;

	sort(vInt.begin(),vInt.end());
	cout << "排序后的向量元素为" << endl;
	for (auto item : vInt) {
		cout << item << "\t";
	}
	cout << endl;

	auto unique_end = unique(vInt.begin(),vInt.end());
	cout << "unique后的向量元素为" << endl;
	for (auto item : vInt) {
		cout << item << "\t";
	}
	cout << endl;

	vInt.erase(unique_end,vInt.end());
	cout << "删除重复元素后的向量元素为" << endl;
	for (auto item : vInt) {
		cout << item << "\t";
	}
	cout << endl;
}

void mutable_lambda() {
	int i = 6;
	auto f = [i]()mutable->bool {if (i > 0) { i--; return false; } else return true; };
	for (int j = 0; j < 6;j++) {
		cout << f() << endl;
	}
}

void itorString() {
	ifstream in("C:\\Users\\xxw\\Desktop\\test.txt");
	if (!in) {
		cout << "无法打开文件" << endl;
		return;
	}
	//创建流迭代器从文件读取字符串
	istream_iterator<string> in_iter(in);
	//尾后迭代器
	istream_iterator<string> eof;
	vector<string> words;
	while (in_iter!=eof)
	{
		words.push_back(*in_iter++);
	}

	for (auto item:words) {
		cout << item << endl;
	}
}

//使用反向迭代器
void reverseIterator() {
	srand(time(0));
	list<int> lInt;
	for (int i = 0; i < 100;i++) {
		int tmp = rand() % 100;
		lInt.push_back(tmp);
	}

	for (auto item:lInt) {
		cout << item << "\t";
	}
	cout << endl;

	int toFind;
	cin >> toFind;
	auto rIter = find(lInt.rbegin(), lInt.rend(),toFind);

	rIter++;
	int location = 1;
	for (auto it = lInt.begin(); it != rIter.base();it++,location++);

	if (location > lInt.size()) {
		cout << "" << endl;
		return;
	}

	cout << location << endl;
}

int main10_1() {
	reverseIterator();
	return 0;
}