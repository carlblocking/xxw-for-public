#include<iostream>
#include<string>
#include<vector>
#include<initializer_list>
#include<memory>
#include<stdexcept>
#include<cstring>

using namespace std;

//class StrBlob {
//public:
//	typedef vector<string>::size_type size_type;
//	StrBlob();
//	StrBlob(initializer_list<string> li);
//	size_type size() const { return data->size(); }
//	bool empty() const { return data->empty(); }
//	//添加和删除元素
//	void push_back(const string& t) { data->push_back(t); }
//	void pop_back();
//	//元素访问
//	string& front();
//	const string& front() const;
//	string& back();
//	const string& back() const;
//private:
//	shared_ptr<vector<string>> data;
//public:
//	void check(size_type i, const string& msg) const;
//};
//
//StrBlob::StrBlob() :data(make_shared<vector<string>>) {}
//
//StrBlob::StrBlob(initializer_list<string> li):data(make_shared<vector<string>>(li)) {}
//
//void StrBlob::check(size_type i, const string& msg) const {
//	if (i >= data->size())
//		throw out_of_range(msg);
//}
//
//string& StrBlob::front() {
//	check(0,"front on empty StrBlob");
//	return data->front();
//}
//
//const string& StrBlob::front() const {
//	check(0, "front on empty StrBlob");
//	return data->front();
//}
//
//string& StrBlob::back() {
//	check(0, "back on empty StrBlob");
//	return data->back();
//}
//
//const string& StrBlob::back() const {
//	check(0, "back on empty StrBlob");
//	return data->back();
//}
//
//void StrBlob::pop_back() {
//	check(0, "pop_back on empty StrBlob");
//	data->pop_back();
//}

///////////////////////////////////////////////////////////////////////////////////////
////////////////////                                        ///////////////////////////
////////////////////                                        ///////////////////////////
////////////////////                                        ///////////////////////////
///////////////////////////////////////////////////////////////////////////////////////

//vector<int> *new_vector(void) {
//	return new (nothrow) vector<int>;
//}
//
//void read_ints(vector<int>* pv) {
//	int v;
//	while (cin>>v)
//	{
//		pv->push_back(v);
//	}
//}
//
//void print_ints(vector<int> *pv) {
//	for (auto item:*pv) {
//		cout << item << "\t";
//	}
//	cout << endl;
//}

/////*	auto pv = new_vector1();
//	read_ints1(pv);
//	print_ints1(pv);*/
//shared_ptr<vector<int>> new_vector1(void) {
//	return make_shared<vector<int>>();
//}
//
//void read_ints1(shared_ptr<vector<int>> pv) {
//	int v;
//	while (cin >> v)
//	{
//		pv->push_back(v);
//	}
//}
//
//void print_ints1(shared_ptr<vector<int>> pv) {
//	for (auto &item : *pv) {
//		cout << item << "\t";
//	}
//	cout << endl;
//}

//struct destination {};
//struct connection {};
//
//connection connect(destination* pd) {
//	cout << "打开链接" << endl;
//	return connection();
//}
//
//void disconnect(connection c) {
//	cout << "关闭连接" << endl;
//}
//
//void f(destination& d) {
//	cout << "直接管理connect" << endl;
//	connection c = connect(&d);
//	cout << endl;
//}
//
//void end_connection(connection* p) {
//	disconnect(*p);
//}
//
//void f1(destination& d) {
//	cout << "使用share_ptr管理connect" << endl;
//	connection c = connect(&d);
//
//	shared_ptr<connection> p(&c,end_connection);
//	cout << endl;
//}

void read_int_and_blank() {
	char c;
	char* r = new char[20];
	int l = 0;
	while (cin.get(c))
	{
		if (isspace(c)) {
			break;
		}
		r[l++] = c;
		if (l==20) {
			cout << "容量已达上限" << endl;
			break;
		}
	}
	r[l] = 0;
	cout << r << endl;
	delete[] r;
}

void use_allocator() {
	allocator<string> alloc;
	auto const p = alloc.allocate(100);
	string s;
	string* q = p;
	while (cin>>s&&q!=p+100)
	{
		alloc.construct(q++,s);
	}
	const size_t size = q - p;

	for (size_t i = 0; i < size;i++) {
		cout << p[i] << endl;
	}

	while (q!=p)
	{
		alloc.destroy(--q);
	}
	alloc.deallocate(p,100);
}

int main12_1() {

	//destination d;
	//f(d);
	//f1(d);

	use_allocator();

	return 0;
}