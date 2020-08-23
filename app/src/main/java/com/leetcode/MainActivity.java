package com.leetcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
    }

    public void clickTv(View v) {
//        long l = System.currentTimeMillis();
//        Log.d("lizheren", new NQueen1().totalNQueens(8) + "");
//        Log.d("lizheren", System.currentTimeMillis() - l + "");
    }
}