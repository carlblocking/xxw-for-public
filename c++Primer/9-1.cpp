#include<iostream>
#include<vector>
#include<list>
#include<string>
#include<deque>
#include<forward_list>
#include<memory>

using namespace std;

bool search_vec(vector<int>::iterator beg,vector<int>::iterator end, int val) {
	for (; beg != end;beg++) {
		if (*beg==val) 
			return true;
	}
	return false;
}

int main9_1_1() {
	forward_list<int> flist = {1,2,3,4,5,6,87,2,3,23,232,1};

	auto prev = flist.before_begin();//前驱元素
	auto curr = flist.begin();//当前元素

	while (curr!=flist.end())
	{
		if (*curr & 1)
			curr = flist.erase_after(prev);
		else {
			prev = curr;
			curr++;
		}
	}

	for (auto item: flist) {
		cout << item<<"\t";
	}
	return 0;
}

void replace_string(string& s, const string& oldVal, const string& newVal) {
	int p = 0;
	while ((p=s.find(oldVal,p))!=string::npos)//在s中查找olVal
	{
		s.replace(p,oldVal.size(),newVal);//找到的字串替换为新的内容
		p += newVal.size();//下标调整到新插入的内容之后
	}
}

void name_string(string& name, const string& prefix, const string& suffix) {
	name.insert(name.begin(),1,' ');
	name.insert(name.begin(),prefix.begin(),prefix.end());
	name.append(" ");
	name.append(suffix.begin(),suffix.end());
}

void find_char(string& s,const string& chars) {
	cout << "在" << s<<"中查找字符"<<chars<<endl;
	string::size_type pos = 0;
	while ((pos=s.find_first_of(chars,pos))!=string::npos)
	{
		cout << "pos:" << pos << ",char:" << s[pos] << endl;
		pos++;
	}
}

void stringToInt() {
	vector<string> sVector = {"-10","56","123"};
	int sum = 0;
	for (auto it = sVector.begin(); it != sVector.end();it++) {
		sum += stoi(*it);
	}
	cout << sum << endl;
}

int main9_1_2() {
	stringToInt();
	cout << stoi("456") << endl;
	return 0;
}