package com.example;

/**
 * 238 除自身以外数组的乘积
 */
public class Subject236Demo {
    public static void main(String[] args) {
        productExceptSelf(new int[]{1, 2, 3, 4});
    }

    /**
     * L[i] = num[i-1]！
     * f(i) = L(i)*R(i)
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] lints = new int[nums.length];
        int[] rints = new int[nums.length];
        lints[0] = 1;
        rints[nums.length - 1] = 1;

        int p = 1, q = nums.length - 2;
        while (p < nums.length && q >= 0) {
            lints[p] = lints[p - 1] * nums[p - 1];
            rints[q] = rints[q + 1] * nums[q + 1];
            p++;
            q--;
        }

        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            answer[i] = lints[i] * rints[i];
        }
        return answer;
    }

    /**
     * 用answer做L[i]
     */
    public static int[] productExceptSelf2(int[] nums) {
        int[] rints = new int[nums.length];
        int[] answer = new int[nums.length];

        rints[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rints[i] = rints[i + 1] * nums[i + 1];
        }
        int n = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = n * rints[i];
            n = n * nums[i];
        }
        return answer;
    }
}