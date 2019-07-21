package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {
    private static final String LOG_TAG = Emojifier.class.getSimpleName();

    /**
     * Detects number of faces and log them
     *
     * @param context
     * @param bitmap
     */
    public static void detectFaces(Context context, Bitmap bitmap) {
        //Create Face Detector
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        SparseArray<Face> faces = detector.detect(frame);

        Log.d(LOG_TAG, "No of faces :" + faces.size());

        Toast.makeText(context, "No of faces :" + faces.size(), Toast.LENGTH_SHORT).show();

        detector.release();

    }
}
