package com.leetcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.leetcode.no201_250.No239;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
    }

    public void clickTv(View v) {
        int[] a = {9, 10, 9, -7, -4, -8, 2, -6};
        No239 no239 = new No239();
        no239.maxSlidingWindow(a, 5);

    }
}