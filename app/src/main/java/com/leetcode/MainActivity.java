package com.leetcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.leetcode.standard.HeapSort;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
    }

    public void clickTv(View v) {
        int[] a={3,5,3,3,2,2,3};
        HeapSort.sort(a);
        for(int ans:a){
            Log.d("lizheren", "clickTv: "+ans);
        }
    }
}