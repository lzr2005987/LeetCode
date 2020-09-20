package com.leetcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.leetcode.no1_50.No37;

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
/*        GoodsChoices.AttrList attrList = new GoodsChoices.AttrList();
        List<String> values = new ArrayList<>();
        values.add("白色");
        values.add("黑色");
        attrList.label = "颜色";
        attrList.value = values;

        GoodsChoices.AttrList attrList1 = new GoodsChoices.AttrList();
        List<String> values1 = new ArrayList<>();
        values1.add("8g");
        values1.add("16g");
        attrList1.label = "内存";
        attrList1.value = values1;

        GoodsChoices.AttrList attrList2 = new GoodsChoices.AttrList();
        List<String> values2 = new ArrayList<>();
        attrList1.label = "尺寸";
        attrList1.value = values2;

        List<GoodsChoices.AttrList> list = new ArrayList<>();
        list.add(attrList);
        list.add(attrList1);
        list.add(attrList2);
        List<HashMap<String, String>> choices = new GoodsChoices().getChoices(list);
        Log.d("lizheren", "clickTv: "+choices);*/
        No37 no37 = new No37();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        no37.solveSudoku(board);
    }
}