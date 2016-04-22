package com.zzx.math;

/**
 * Created by Administrator on 2016/4/22 0022.
 */
public abstract class LoopThread {

    Thread thread = null;
    boolean isstart = false;
    private boolean shutdown = false;

    protected abstract void threadLoop();

    public void Init(){
        if (thread == null){
            thread = new Thread(new Run());
            thread.start();
        }
    }

    public void Shutdown(){
        synchronized (this)
        {
            shutdown = true;

            if (thread == null)
            {
                return;
            }

            if (thread != null)
            {
                try{
                    thread.join(5000);
                    if(!thread.isInterrupted()){
                        thread.interrupt();
                    }
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    thread.join(5000);
                    if(!thread.isInterrupted()){
                        thread.interrupt();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (UnsupportedOperationException e) {
                    e.printStackTrace();
                }

                thread = null;
            }
        }
    }

    public class Run implements Runnable {

        @Override
        public void run() {
            while (!shutdown) {
                try {
                    threadLoop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
