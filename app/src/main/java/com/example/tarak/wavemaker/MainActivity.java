package com.example.tarak.wavemaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("jni-bridge");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startEngine();

        // Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();
    private native void touchEvent(int action);

    private native void startEngine();

    private native void stopEngine();

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchEvent(event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public void onDestroy() {
        stopEngine();
        super.onDestroy();
    }
}
