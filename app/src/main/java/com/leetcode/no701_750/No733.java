package com.leetcode.no701_750;

public class No733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image, sr, sc, -1, image[sr][sc]);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                if (image[i][j] == -1) {
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int newColor, int oldColor) {
        image[sr][sc] = newColor;
        if (image.length > sr + 1 && image[sr + 1][sc] == oldColor) {
            fill(image, sr + 1, sc, newColor, oldColor);
        }
        if (image[0].length > sc + 1 && image[sr][sc + 1] == oldColor) {
            fill(image, sr, sc + 1, newColor, oldColor);
        }
        if (sr > 0 && image[sr - 1][sc] == oldColor) {
            fill(image, sr - 1, sc, newColor, oldColor);
        }
        if (sc > 0 && image[sr][sc - 1] == oldColor) {
            fill(image, sr, sc - 1, newColor, oldColor);
        }
    }
}
