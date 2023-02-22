package com.example;

import java.util.Arrays;

/**
 * leetcode 322 零钱兑换
 */
public class Subject322Demo {

    /**
     * 使用动态规划 
     * F(3)=min(F(3−c1),F(3−c2),F(3−c 3))+1
        =min(F(3−1),F(3−2),F(3−3))+1
        =min(F(2),F(1),F(0))+1
        =min(1,1,0)+1
        =1
     */
    public int coinChange(int[] coins, int amount) {

        if (amount <= 0) {
            return 0;
        }
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i < max; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }
}