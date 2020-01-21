package com.leetcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
        No257.TreeNode root = new No257.TreeNode(1);
        No257.TreeNode root1 = new No257.TreeNode(2);
        No257.TreeNode root2 = new No257.TreeNode(3);
        No257.TreeNode root3 = new No257.TreeNode(5);
        root.left = root1;
        root.right = root2;
        root1.right = root3;
        new No257().binaryTreePaths(root);
    }
}