#include "opencv2/objdetect/objdetect.hpp"
#include "opencv2/highgui/highgui.hpp"
#include "opencv2/imgproc/imgproc.hpp"

#include <iostream>
#include <stdio.h>

using namespace std;
using namespace cv;
int main() {

	VideoCapture cap(0);

	if (!cap.isOpened()) {
		cout << "摄像机开启失败!";
		return -1;
	}

	//加载训练文件，文件应在工程文件目录下

	CascadeClassifier open_palm_cascade;
	CascadeClassifier closed_palm_cascade;
	open_palm_cascade.load("C:\\Users\\xxw\\Desktop\\open_palm.xml");
	closed_palm_cascade.load("C:\\Users\\xxw\\Desktop\\closed_palm.xml");

	if (open_palm_cascade.empty()) {
		cout << "无法加载open_palm配置文件! "
			"请检查目录 " << endl;
		return -1;
	}

	if (closed_palm_cascade.empty()) {
		cout << "无法加载closed_palm文件! "
			"请检查目录 " << endl;
		return -1;
	}

	vector<Rect> open_palms;
	vector<Rect> closed_palms;

	while (char(waitKey(1)) != 'q' && cap.isOpened()) {
		double t0 = getTickCount();
		Mat frame;
		cap >> frame;
		if (frame.empty()) {
			cout << "视频结束!";
			break;
		}

		// 检测所有张开的手掌
		open_palm_cascade.detectMultiScale(frame, open_palms, 1.3, 4, 0, Size(50, 50));
		closed_palm_cascade.detectMultiScale(frame, closed_palms, 1.3, 4, 0, Size(50, 50));

		if (closed_palms.size() != 0) {

			for (int i = 0; i < closed_palms.size(); i++) {

				cout << "=============Detected a closed palm!=============" << endl;

				Point closed_palm_rect_p1(closed_palms[i].x, closed_palms[i].y);
				Point closed_palm_rect_p2(closed_palms[i].x + closed_palms[i].width, closed_palms[i].y + closed_palms[i].height);

				//圈出手掌
				rectangle(frame, closed_palm_rect_p1, closed_palm_rect_p2, Scalar(0, 255, 0));
				putText(frame, "Closed Palm", closed_palm_rect_p1, FONT_HERSHEY_SIMPLEX,
					1, Scalar(0, 255, 0), 1, 5, false);
			}
		}
		for (int i = 0; i < open_palms.size(); i++) {

			cout << "=============Detected an open palm!=============" << endl;


			Point open_palm_rect_p1(open_palms[i].x, open_palms[i].y);
			Point open_palm_rect_p2(open_palms[i].x + open_palms[i].width, open_palms[i].y + open_palms[i].height);


			rectangle(frame, open_palm_rect_p1, open_palm_rect_p2, Scalar(255, 0, 0));
			putText(frame, "Open Palm", open_palm_rect_p1, FONT_HERSHEY_SIMPLEX,
				1, Scalar(255, 0, 0), 1, 5, false);
		}

		imshow("Video Capture", frame);
		cout << "Frame rate = " << getTickFrequency() / (getTickCount() - t0) << endl;
	}
	return 0;
}