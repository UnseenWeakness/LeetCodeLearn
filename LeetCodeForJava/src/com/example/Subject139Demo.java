package com.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode 139题 单词拆分
 */
public class Subject139Demo {

    public static void main(String[] args) {

        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int b = s.length();
        int a = 0;
        while (a < b) {
            int t = a;
            for (String word : wordDict) {
                int length = word.length();
                if (a + length <= b) {
                    String sub = s.substring(a, a + length);
                    System.out.println(sub);
                    if (word.equals(sub)) {
                        a = a + word.length();
                    }
                }
            }
            if (t == a) {
                break;
            }
        }
        return true;
    }

    public static boolean dfs(String s, List<String> wordDict, int k) {
        if (k >= s.length()) {
            return true;
        }
        boolean flage = false;
        for (String word : wordDict) {
            int length = word.length();
            if (k + length <= s.length()) {
                String sub = s.substring(k, k + length);
                System.out.println(sub);
                if (word.equals(sub)) {
                    flage = flage || dfs(s, wordDict, k + length);
                }
            }
        }
        return flage;
    }


    /**
     * 动态规划
     */
    public static boolean wordBreak2(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] & set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

    }

}