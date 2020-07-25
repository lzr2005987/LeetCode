package com.leetcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.leetcode.standard.DiscountCalculate;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
    }

    public void clickTv(View v) {
//        No785 n=new No785();
//        int[][] a={{2,4},{2,3,4},{0,1},{1},{0,1},{7},{9},{5},{},{6},{12,14},{},{10},{},{10},{19},{18},{},{16},{15},{23},{23},{},{20,21},{},{},{27},{26},{},{},{34},{33,34},{},{31},{30,31},{38,39},{37,38,39},{36},{35,36},{35,36},{43},{},{},{40},{},{49},{47,48,49},{46,48,49},{46,47,49},{45,46,47,48}};
//        boolean bipartite = n.isBipartite(a);
//        Log.d("lizheren", "clickTv: "+bipartite);

//        List<Integer> list = new ArrayList<>();
//        list.add(20);
//        list.add(29);
//        list.add(30);
//        list.add(18);
//        list.add(50);
//        DiscountCalculate.getDiscountDp(list, 60);

        double[] list = new double[]{20.12, 29.24, 30.34, 18.12, 50.74};
        DiscountCalculate.getDiscountDpOptimize(60.25, list);
    }
}