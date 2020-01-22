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
        int[][] matrix = new int[][]{{3, 5, 9, 9, 14}, {7, 8, 11, 15, 15}, {8, 10, 16, 16, 17}};
        new No240().searchMatrix(matrix, 12);
    }
}