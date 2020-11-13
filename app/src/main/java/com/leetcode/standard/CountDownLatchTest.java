package com.leetcode.standard;

import android.util.Log;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public void countdown() {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            startThread(i, latch);
        }
        try {
            latch.await();
            Log.d("lizheren", "fin");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void startThread(final int i, final CountDownLatch latch) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("lizheren", "startThread: " + i);
                latch.countDown();
            }
        }).start();
    }
}
