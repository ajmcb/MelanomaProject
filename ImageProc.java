import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
import com.googlecode.javacv.JavaCV;

public class ImageProc {
	public static void main (String [] args) {
		transformPerspective("/home/kuba/repos/melanoma-edinburgh/Edinburgh_Castle_princes.jpg");
	}

    public static void transformPerspective(String filename) { 
        CvMat mmat = cvCreateMat(3,3,CV_32FC1);
        IplImage image = cvLoadImage(filename);
        
        
        if (image != null) {
            double[] pts1 = new double[] {289.0,142.0, 609.0, 192.0, 754.0, 280.0, 32.0, 224.0};
            double[] pts2 = new double[] {217.0, 247.0, 550.0, 300.0, 671.0, 386.0, 3.0, 316.0};
            JavaCV.getPerspectiveTransform(pts1, pts2, mmat);
            cvWarpPerspective(image, image, mmat);
            cvSaveImage("Edinburgh_Castle_princes_transformed.jpg", image);
            cvReleaseImage(image);
        }
        
    }
    
    public static void smooth(String filename) { 
        IplImage image = cvLoadImage(filename);
        if (image != null) {
            cvSmooth(image, image, CV_GAUSSIAN, 3);
            cvSaveImage(filename, image);
            cvReleaseImage(image);
        }
    }
}


}
