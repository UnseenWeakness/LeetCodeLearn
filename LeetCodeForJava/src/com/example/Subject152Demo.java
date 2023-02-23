package com.example;

import java.util.Arrays;

/**
 * leetcode 152 乘积最大子数组
 */
public class Subject152Demo {

    public static void main(String[] args) {
        System.out.println(maxProduct2(new int[]{-4, -3, -2}));
    }


    // 强行计算
    public static int maxProduct(int[] nums) {

        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int t = 1;
            for (int j = i; j < nums.length; j++) {
                t = t * nums[j];
                dp[i] = Math.max(dp[i], t);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }


    // 动态规划
    public static int maxProduct2(int[] nums) {
        int p = nums.length;
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        for (int i = 1; i < p; i++) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(ans, maxF);
        }
        return ans;

    }
}