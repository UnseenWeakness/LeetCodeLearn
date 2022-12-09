package com.example;

/**
 * leetcode 221题 最大正方形
 */
public class Subject221Demo {
    public static void main(String[] args) {

        char[][] ints = {
            {'0', '0', '1', '0'},
            {'1', '1', '1', '1'},
            {'1', '1', '1', '1'},
            {'1', '1', '1', '0'},
            {'1', '1', '0', '0'},
            {'1', '1', '1', '1'},
            {'1', '1', '1', '0'}
        };
        int i = maximalSquare(ints);
    }

    // 暴力求法
    public static int maximalSquare(char[][] matrix) {
        int b = matrix.length;
        int c = matrix[0].length;
        int maxArea = 0;
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '1') {
                    maxArea = Math.max(pointMaxSqu(matrix, i, j), maxArea);
                }
            }
        }
        return maxArea;
    }

    public static int pointMaxSqu(char[][] matrix, int i, int j) {
        int p = i;
        int q = j;
        // 计算最大可能边长
        int maxSideLength = Math.min(matrix.length - p, matrix[0].length - q);
        System.out.println("maxSideLength:" + maxSideLength);
        if (maxSideLength == 1) {
            return 1;
        }
        int t = 1;
        boolean flage = true;
        while (t < maxSideLength) {
            int m = 0;
            while (m <= t) {
                if (matrix[p + t][q + m] == '0' || matrix[p + m][q + t] == '0') {
                    flage = false;
                    break;
                }
                m++;
            }
            if (!flage) {
                break;
            }
            t++;
        }
        return t * t;

    }

    // 动态规划法

    /**
     * 计算当前point 能组成最大的正方形边长 dp(i,j)=min(dp(i-1,j),dp(i-1,j-1),dp(i,j-1)) + 1
     * 考虑边界时当i,j有一个为0时，则以位置 (i, j)(i,j) 为右下角的最大正方形的边长只能是 1
     */
    public static int maximalSquare2(char[][] matrix) {
        int maxSide = 0;

        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return maxSide;
        }
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    int pointVal = 1;
                    if (i != 0 && j != 0) {
                        pointVal = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, pointVal);
                    dp[i][j] = pointVal;
                }
            }
        }
        return maxSide * maxSide;
    }
}