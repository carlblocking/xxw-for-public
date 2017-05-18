#include<iostream>
#include<map>
#include<vector>
#include<algorithm>
#include<string>

using namespace std;

void stringToLowerCase(string& source) {
	for (int i = 0; i < source.size();i++) {
		if (source[i]>='A'&&source[i]<='Z') {
			source[i] -= ('A'-'a');
		}
		if (source[i] == ',' || source[i] == '.')
			source.erase(i,1);
	}
}

//添加家族
void add_family(map<string,vector<string>>& families,const string& family) {
	families[family];
}

//家族添加成员
void add_child(map<string,vector<string>>& families,const string& family, const string& child) {
	families[family].push_back(child);
}

int main11_1() {
	map<string, vector<string>> families;
	add_family(families, "sa");
	add_child(families, "sa", "dsa");
	add_child(families, "sa", "asd");
	add_child(families, "sa", "dsads");
	add_child(families, "sa", "dsahjkjn");

	for (auto f:families) {
		cout << f.first << "家的孩子" << endl;
		for (auto child:f.second) {
			cout << child << endl;
		}
	}
	cout << endl;

	vector<pair<string, int>> lisa;
	lisa.push_back(pair<string,int>("sa",12));
	cout << lisa[0].first<<"\t"<<lisa[0].second << endl;

	return 0;
}