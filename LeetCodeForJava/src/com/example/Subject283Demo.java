package com.example;

/**
 * leetcod 283 移动零
 */
public class Subject283Demo {
  
    public void moveZeroes(int[] nums) {
        int p = nums.length;
        for (int i = 0; i < p; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < p; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 双指针
     */
    public void moveZeroes2(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > p) {
                    nums[p] = nums[i];
                    nums[i] = 0;
                }
                p++;
            }
        }
    }
}