//#include<iostream>
//#include<cv.h>
//#include<highgui.h>
//using namespace std;
//void PrintMat(CvMat *A);//显示矩阵
//void GenRandn(CvMat *arr,int seed);//生成正态分布的随机矩阵
//void GenRand(CvMat *arr,int seed);//生成0-1分布的随机矩阵
//static int cmp_func(const void* _a,const void* _b,void* userdata);//比较函数
//void Test_Multiply();//测试矩阵乘法
//void Test_cvGetRawData();//将缓存数据填入CvMat数组中;
//void Test_DCT();//计算DCT变幻,一种只使用实数的离散傅里叶变换
//void Test_Rand();//生成随机数
//void Test_SeqSort();//二维序列排序
//int main() {
//	Test_Multiply();
//	Test_cvGetRawData();
//	Test_DCT();
//	Test_Rand();
//	Test_SeqSort();
//	return 0;
//}
//
//void Test_SeqSort() {
//	CvMemStorage* storage = cvCreateMemStorage(0);
//	CvSeq* seq = cvCreateSeq(CV_32SC2,sizeof(CvSeq),sizeof(CvPoint),storage);
//
//	cout << "===Test sequence sorting===" << endl;
//	for (int i = 0; i < 10; i++)
//	{
//		CvPoint pt;
//		pt.x = rand() % 1000;
//		pt.y = rand() % 1000;
//		cvSeqPush(seq,&pt);
//	}
//
//	cout << "Original point set"<< endl;
//	for (int i = 0;i < seq->total;i++)
//	{
//		CvPoint* pt = (CvPoint*)cvGetSeqElem(seq,i);
//		cout <<"("<<pt->x<<","<<pt->y<<")"<< endl;
//	}
//
//	cvSeqSort(seq,cmp_func,0);/*user data is not used here*/
//
//	cout << "After sorting:" << endl;
//	for (int i = 0; i < seq->total; i++)
//	{
//		CvPoint* pt = (CvPoint*)cvGetSeqElem(seq,i);
//		cout << "(" << pt->x << "," << pt->y << ")" << endl;
//	}
//
//	cvClearSeq(seq);
//	cvReleaseMemStorage(&storage);
//}
//
//static int cmp_func(const void* _a, const void* _b, void* userdata) {
//	CvPoint* a = (CvPoint*)_a;
//	CvPoint* b = (CvPoint*)_b;
//	int y_diff = a->y - b->y;
//	int x_diff = a->x - b->x;
//	return y_diff ? y_diff : x_diff;
//}
//
////生成随机矩阵
//void Test_Rand() {
//	CvMat* a = cvCreateMat(10,6,CV_32F);
//	int i;
//	cout << "===Test generating random matrix==="<< endl;
//	for (i = 0; i < 5; i++)
//	{
//		GenRandn(a,i);
//		PrintMat(a);
//	}
//	cvReleaseMat(&a);
//}
//
//void PrintMat(CvMat* A) {
//	int i, j;
//	for ( i = 0; i < A->rows; i++)
//	{
//		printf("\n");
//		switch (CV_MAT_DEPTH(A->type))
//		{
//		case CV_32F:
//		case CV_64F:
//			for (j  = 0; j < A->cols; j++)
//			{
//				printf("%9.3f",(float)cvGetReal2D(A,i,j));
//			}
//			break;
//		case CV_8U:
//		case CV_16U:
//			for ( j = 0; j < A->cols; j++)
//			{
//				printf("%6d",(int)cvGetReal2D(A,i,j));
//			}
//			break;
//		default:
//			break;
//		}
//	}
//	printf("\n");
//}
//
//void GenRand(CvMat* arr,int seed) {
//	CvRandState rng;
//	rng.state = CvRNG(0xffffffff);
//	cvRandInit(&rng,
//		0,1,
//		seed,
//		CV_RAND_UNI
//		);
//	cvRandArr(&rng.state,arr,CV_RAND_UNI,cvRealScalar(0),cvRealScalar(1));
//}
//
//void GenRandn(CvMat* arr,int seed) {
//	CvRandState rng;
//	rng.state = CvRNG(0xffffffff);
//	cvRandInit(&rng,
//		0, 1,
//		seed,
//		CV_RAND_NORMAL
//		);
//	cvRandArr(&rng.state,arr,CV_RAND_NORMAL,
//		cvRealScalar(0),
//		cvRealScalar(1)
//		);
//}
//
//void Test_Multiply() {
//	double a[] = {1,2,3,4,
//				  5,6,7,8,
//				  9,10,11,12};
//	double b[] = {1,5,9,
//				  2,6,10,
//				  3,7,11,
//				  4,8,12};
//	double c[9];
//	CvMat Ma, Mb, Mc;
//	cout << "===Test Multiply==="<< endl;
//	cvInitMatHeader(&Ma,3,4,CV_64FC1,a,CV_AUTOSTEP);
//	cvInitMatHeader(&Mb,4,3,CV_64FC1,b,CV_AUTOSTEP);
//	cvInitMatHeader(&Mc,3,3,CV_64FC1,c,CV_AUTOSTEP);
//
//	cvMatMulAdd(&Ma,&Mb,0,&Mc);
//
//	PrintMat(&Ma);
//	PrintMat(&Mb);
//	PrintMat(&Mc);
//
//	return;
//}
//
//void Test_cvGetRawData() {
//	float* data;
//	int step;
//	float a[] = {1,2,3,4,-5,6,7,8,9,-10,-11,12};
//	CvMat array;
//	CvSize size;
//	int x, y;
//	cout << "Test get raw data"<< endl;
//	cvInitMatHeader(&array,3,4,CV_32FC1,a,CV_AUTOSTEP);
//	
//	cvGetRawData(&array,(uchar**)&data,&step,&size);
//	step /= sizeof(data[0]);
//
//	cout << "CvMat=" << endl;
//	PrintMat(&array);
//	cout << "Data=" << endl;
//	for (y  = 0;  y< size.height; y++,data+=step)
//	{
//		printf("\n");
//		for ( x = 0; x < size.width; x++)
//		{
//			data[x] = (float)fabs(data[x]);
//			printf("%8.2f",data[x]);
//		}
//	}
//	printf("\n");
//	return;
//}
//
//void Test_DCT() {
//	float data[] = {1,2,3,4,5,6,7,8};
//	CvMat a;
//	a = cvMat(2,4,CV_32FC1,data);
//	cout << "===Test DCT==="<<  endl;
//	cout << "Original matrix" << endl;
//	PrintMat(&a);
//	cvDCT(&a,&a,CV_DXT_FORWARD);
//	cout << "2-D DCT=" << endl;
//	PrintMat(&a);
//	cvDCT(&a, &a, CV_DXT_INVERSE);
//	cout << "2-D IDCT=" << endl;
//	PrintMat(&a);
//}
