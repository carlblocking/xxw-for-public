#include<iostream>
#include<string>
#include<highgui.h>
#include<cv.h>
using namespace cv;
using namespace std;
IplImage* callback(IplImage* image);
int main() {
	char path[] = "C:\\Users\\xxw\\Desktop\\test.avi";//存储的路径
	IplImage*  image = 0;

	//CvVideoWriter* writer = writer = cvCreateVideoWriter(path, CV_FOURCC('M', 'J', 'P', 'G'),fps, cvSize(frameW, frameW), isColor);
	//这种方法不推荐，因为自己指定的文件编码方式系统可能不支持

	CvCapture* capture = cvCaptureFromCAM(0);//通过摄像头收集视频

	if(!capture){
		cout << "摄像头初始化失败"<< endl;
		return -1;
	}

	cvNamedWindow("main",1);//创建窗口，用于实时显示采集的图像

	image = cvQueryFrame(capture);	//从视频中读取每一帧的图像，存入视频中。因为视频的本质是连续的图像
	CvVideoWriter*  writer = cvCreateVideoWriter(path, -1, 25, cvSize(image->width, image->height));//创建文件写入对象writer

	while (capture)
	{
		image = callback(cvQueryFrame(capture));
		cvWriteFrame(writer,image);
		cvShowImage("main",image);
		//if (cvWaitKey(1) == 'q')//如果按下的为q，则退出
		if (cvWaitKey(1)=='q')
			break;
	}

	//释放各种资源，会c++的懂的
	cvReleaseCapture(&capture);
	cvReleaseVideoWriter(&writer);
	cvDestroyWindow("main");

	return 0;
}

IplImage* callback(IplImage* image) {
	IplImage* image1 = image;
	int i, j;

	assert(image);

	for ( i = 0; i < image1->height; i+=10)
	{
		for (j = (image1->widthStep)*i; j < (image1->widthStep)*(i + 1);j+=image1->nChannels)
		{
			image1->imageData[j] = (char)255;
			image1->imageData[j + 1] = 0;
			image1->imageData[j + 2] = 0;
		}
	}
	return image1;
}