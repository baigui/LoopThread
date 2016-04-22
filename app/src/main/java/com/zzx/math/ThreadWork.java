package com.zzx.math;

import android.util.Log;

/**
 * Created by Administrator on 2016/4/22 0022.
 */
public class ThreadWork extends LoopThread {
    @Override
    protected void threadLoop() {
        Log.v("ThreadWork","这是工作的地方！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
