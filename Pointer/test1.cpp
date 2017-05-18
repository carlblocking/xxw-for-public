#include<iostream>
using namespace std;

#define safeFree(p) saferFree((void**)&(p))

void saferFree(void** pi) {
	if (*pi != NULL&&pi != NULL) {
		free(*pi);
		*pi = NULL;
	}
}

char* getLine(void) {
	const size_t sizeIncrement = 10;
	char* buffer = (char*)malloc(sizeIncrement);
	char* currentPosition = buffer;
	size_t maximunmLength = sizeIncrement;
	size_t length =0 ;
	int character;

	if (currentPosition == NULL)
		return NULL;
	while (1)
	{
		character = fgetc(stdin);
		if (character == '\n')
			break;
		if (++length >= maximunmLength) {
			char* newBuffer =(char*)realloc(buffer,maximunmLength+=sizeIncrement);
			if (newBuffer == NULL) {
				free(buffer);
				return NULL;
			}
			currentPosition = newBuffer + (currentPosition-buffer);
			buffer = newBuffer;
		}
		*currentPosition++ = character;
	}
	*currentPosition = '\0';
	return buffer;
}

char* trim(char* phrase) {
	char* old=phrase;
	char* news = phrase;
	while (*old==' ')
	{
		old++;
	}
	while (*old)
	{
		*(news++) = *(old++);
	}
	*news = 0;
	return (char*)realloc(phrase,strlen(phrase)+1);
}

void display2DArray(int arr[][5],int rows) {
	for (int i = 0; i < rows;i++) {
		for (int j = 0; j < 5;j++) {
			cout << arr[i][j] << "\t";
		}
		cout << endl;
	}
}

void displayUnknow2DArraySize(int* arr, int rows, int cols) {
	for (int i = 0; i < rows;i++) {
		for (int j = 0; j < cols; j++) {
			cout << *(arr + i*cols + j) << "\t";
		}
		cout << endl;
	}
}

void continueAllocate(int rows, int cols) {
	int* matrix = (int*)malloc(rows*cols*sizeof(int));
	for (int i = 1; i <= rows;i++) {
		for (int j = 1; j <= cols;j++) {
			*(matrix + (i-1)*cols + j-1) = i*j;
		}
	}
	for (int i = 0; i < rows;i++) {
		for (int j = 0; j < cols;j++) {
			cout << *(matrix + i*cols + j) << "\t";
		}
		cout << endl;
	}
}

int main1() {
	int mat[2][5] = { {1,2,3,4,5},{8,7,9,6,5} };
	display2DArray(mat,2);
	cout << endl;
	displayUnknow2DArraySize(&mat[0][0],2,5);
	cout << endl;
	continueAllocate(3,5);
	return 0;
}