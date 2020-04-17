package com.leetcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.leetcode.no351_400.No355;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
    }

    public void clickTv(View v) {
        No355 no355 = new No355();
        no355.postTweet(1,1);
        no355.getNewsFeed(1);
        no355.follow(2,1);
        no355.getNewsFeed(2);
    }
}