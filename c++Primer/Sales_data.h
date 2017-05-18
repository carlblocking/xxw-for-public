#ifndef SALES_DATA_H_INCLUDE
#define SALES_DATA_H_INCLUDE

#include<iostream>
#include<string>

using namespace std;

class Sales_data {
	//友元函数们
	friend istream& operator>>(istream&,Sales_data&);
	friend ostream& operator<<(ostream&,const Sales_data&);
	friend bool operator <(const Sales_data&, const Sales_data&);
	friend bool operator ==(const Sales_data&, const Sales_data&);

private:
	string bookNo;//书籍编号
	unsigned units_sold = 0;//销售量
	double sellingprice = 0.0;//原始价格
	double sellprice = 0.0;//实售价格
	double discount = 0.0;//折扣

public ://构造函数的三种方式
	Sales_data() = default;
	Sales_data(const string &bookNo) :bookNo(bookNo) {}
	Sales_data(istream &is) { is >> *this; }

public:
	Sales_data& operator +=(const Sales_data&);
	string isbn() const { return bookNo; }
};

inline bool compareIsbn(const Sales_data& lhs, const Sales_data& rhs) {
	return lhs.isbn() == rhs.isbn();
}

Sales_data operator+(const Sales_data&, const Sales_data&);

inline bool operator ==(const Sales_data & lhs, const Sales_data& rhs) {
	return lhs.units_sold == rhs.units_sold&&lhs.sellingprice == rhs.sellingprice&&lhs.sellprice == rhs.sellprice
		&&lhs.isbn()==rhs.isbn();
}



#endif
