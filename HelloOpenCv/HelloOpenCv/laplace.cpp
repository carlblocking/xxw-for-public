//#include<iostream>
//#include<cv.h>
//#include<highgui.h>
//#include<string>
//using namespace std;
//using namespace cv;
//int main() {
//	int i;
//	cout << "请输入数字，0表示读取视频文件，1表示用摄像头读取视频"<< endl;
//	cin >> i;
//	IplImage* laplace = 0;
//	IplImage* colorlaplace = 0;
//	IplImage* planes[3] = {0,0,0};//多个图像画面
//	CvCapture* capture = 0;
//	char path[] = "C:\\Users\\xxw\\Desktop\\test.avi";
//	switch (i)
//	{
//	case 0:
//		capture = cvCaptureFromFile("C://Users//xxw//Desktop//test.MOV");
//		if (!capture) { cout << "no capture" << endl; return 0; }
//		break;
//	case 1:
//		capture = cvCaptureFromCAM(0);
//		if (!capture) { cout << "no capture" << endl; return 0; }
//		break;
//	default:
//		return 0;
//		break;
//	}
//	cvNamedWindow("main",1);
//	for (;;)
//	{
//		IplImage* frame = 0;
//		int i;
//		frame = cvQueryFrame(capture);
//		if (!frame)break;
//		if (!laplace)
//		{
//			for ( i = 0; i < 3; i++)
//				planes[i] = cvCreateImage(cvSize(frame->width,frame->height),8,1);
//			laplace = cvCreateImage(cvSize(frame->width, frame->height), IPL_DEPTH_16S, 1);
//			colorlaplace= cvCreateImage(cvSize(frame->width, frame->height), 8, 3);
//		}
//		cvCvtPixToPlane(frame,planes[0],planes[1],planes[2],0);
//		for ( i = 0; i < 3; i++)
//		{
//			cvLaplace(planes[i],laplace,3);
//			cvConvertScaleAbs(laplace,planes[i],1,0);
//		}
//		cvCvtPlaneToPix(planes[0],planes[1],planes[2],0,colorlaplace);
//		colorlaplace->origin = frame->origin;
//		cvShowImage("main",colorlaplace);
//		if (cvWaitKey(10) >= 0) { break; }
//	}
//	cvReleaseCapture(&capture);
//	cvDestroyWindow("main");
//	return 0;
//}