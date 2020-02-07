package com.example.android.scorecard;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    int initial = 0;
    int initial2 = 0;
    private GestureDetector mdetector;
    private GestureDetector detector;


    View.OnTouchListener touchListener = new View.OnTouchListener() {


        @Override
        public boolean onTouch(View v, MotionEvent event) {

            return mdetector.onTouchEvent(event);
        }
    };

    View.OnTouchListener touchListener2 = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            return detector.onTouchEvent(event);
        }


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        View myView = findViewById(R.id.ll1);
        View myView2 = findViewById(R.id.ll2);
        mdetector = new GestureDetector(this, new MyGestureListener());
        detector = new GestureDetector(this, new MyGestureListener2());
        myView.setOnTouchListener(touchListener);
        myView2.setOnTouchListener(touchListener2);

    }


    public void quantityTextView(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.button);
        quantityTextView.setText("" + number);
    }

    public void quantityTextView2(int number) {
        TextView quantityTextView2 = (TextView) findViewById(R.id.button2);
        quantityTextView2.setText("" + number);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {


        @Override
        public boolean onDown(MotionEvent event) {
            Log.d("TAG", "onDown: ");

            // don't return false here or else none of the other gestures will work
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.i("TAG", "onSingleTapConfirmed: ");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.i("TAG", "onLongPress: ");
            initial = 0;
            quantityTextView(initial);

        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.i("TAG", "onDoubleTap: ");
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.i("TAG", "onScroll: ");
            return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            Log.d("TAG", "onFling: ");
            if (event1.getY() - event2.getY() > 50) {
                initial++;
                quantityTextView(initial);
                return true;
            }

            if ((event2.getY() - event1.getY() > 50) && (initial > 0)) {
                initial--;
                quantityTextView(initial);
                return true;
            }

            return true;
        }
    }

    //Method for team GREEN
    class MyGestureListener2 extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent event) {
            Log.d("TAG", "onDown: ");

            // don't return false here or else none of the other gestures will work
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.i("TAG", "onSingleTapConfirmed: ");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.i("TAG", "onLongPress: ");
            initial2 = 0;
            quantityTextView2(initial2);

        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.i("TAG", "onDoubleTap: ");
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.i("TAG", "onScroll: ");
            return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            Log.d("TAG", "onFling: ");

            if (event1.getY() - event2.getY() > 50) {
                initial2++;
                quantityTextView2(initial2);

                return true;

            }

            if ((event2.getY() - event1.getY() > 50) && (initial2 > 0)) {
                initial2--;
                quantityTextView2(initial2);
                return true;
            }
            return true;
        }
    }
}

