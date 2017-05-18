#include<iostream>
#include<stdexcept>
#include<fstream>
#include<string>
#include<vector>
#include<sstream>

using namespace std;

int main8_1_1() {
	ifstream in("C:\\Users\\xxw\\Desktop\\test.txt");
	if (!in) {
		cout << "无法打开文件" << endl;
		return -1;
	}
	string line;
	vector<string> lines;
	//while (getline(in,line))//以行为单位
	while (in>>line)//以单词为单位
	{
		lines.push_back(line);
	}
	in.close();

	for (auto it = lines.cbegin(); it != lines.cend();it++) {
		cout << *it << endl;
	}
	return 0;
}

ifstream& f(ifstream& in) {
	string v;
	while (in>>v,!in.eof())
	{
		if (in.bad())
			throw runtime_error("IO错误");
		if (in.fail()) {
			cerr << "数据错误，请重试" << endl;
			in.clear();
			in.ignore(100,'\n');
			continue;
		}
		cout << v << endl;
	}
	in.clear();
	return in;
}

int main8_1_2() {
	ifstream in("C:\\Users\\xxw\\Desktop\\test.txt");
	if (!in) {
		cerr << "无法打开文件" << endl;
		return -1;
	}
	

	string line;
	vector<string> lines;
	while (getline(in,line))
	{
		lines.push_back(line);
	}

	for (auto it = lines.cbegin(); it != lines.cend();it++) {
		istringstream line_str(*it);
		string word;
		while (line_str>>word)
		{
			cout << word << "\t";
		}
		cout << endl;
	}
	return 0;
}

int main8_1_3() {
	return 0;
}