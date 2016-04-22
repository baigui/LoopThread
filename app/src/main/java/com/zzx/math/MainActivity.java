package com.zzx.math;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    LoopThread loopThread = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loopThread =new ThreadWork();
        loopThread.Init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loopThread.Shutdown();
    }
}
