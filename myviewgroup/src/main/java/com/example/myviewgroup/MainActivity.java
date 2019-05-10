package com.example.myviewgroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);
        newCacheThreadPool();

    }

    //特点:
    //核心线程数和最大线程数相同.
    //无超时时间
    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(
                nThreads, nThreads,
                0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>()
        );
    }

    private  void newCacheThreadPool(){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            cachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(index * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(index);
                }
            });
        }
    }
}
