#include<iostream>
#include<string>
#include<assert.h>
using namespace std;

class Student {
public:
	string name;
	int age;
	Student* next;
};

int main() {
	Student* head = new Student();
	Student* stu1= new Student();
	Student* stu2= new Student();
	Student* stu3= new Student();


	stu1->next = stu2;
	stu1->age = 12;
	stu1->name = "lisa";

	stu2->next = stu3;
	stu2->age = 13;
	stu2->name = "carl";
	;
	stu3->next = NULL;
	stu3->age = 15;
	stu3->name = "mimi";

	head= stu1;
	while (head!=NULL)
	{
		cout << head->age << endl;
		cout << head->name << endl;
		head = head->next;
	}
	delete(head);
	delete(stu1);
	delete(stu2);
	delete(stu3);
	return 0;
}