//#include<iostream>
//#include<math.h>
//#include<string>
//#include<cv.h>
//#include<highgui.h>
//using namespace std;
//using namespace cv;
//int main() {
//	int height, width, step, channels;
//	uchar* data;
//	int i, j, k;
//	char path[] = "C:\\Users\\xxw\\Desktop\\123.jpg";
//	Mat image1 = imread(path);
//	IplImage* image = cvLoadImage(path,0);
//	if (image1.empty()) {
//		cout << "文件不存在" << endl;
//		return 0;
//	}
//	height = image->height;
//	width = image->width;
//	step = image->widthStep;
//	channels = image->nChannels;
//	data = (uchar*)image->imageData;
//	cvNamedWindow("main",CV_WINDOW_AUTOSIZE);
//	cvMoveWindow("main",100,100);
//	for ( i = 0; i < height; i++)
//	{
//		for ( j = 0; j < width; j++)
//		{
//			for ( k = 0; k < channels; k++)
//			{
//				data[i*step + j*channels + k] = 255 - data[i*step+j*channels+k];
//			}
//		}
//	}
//	cvShowImage("main",image);
//	cvWaitKey(0);
//	cvReleaseImage(&image);
//	return 0;
//}