package com.offermg.shl.doublePoints;

public class lc_283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        while (index < nums.length && nums[index] != 0) {
            index++;
        }

        if (index == nums.length) return;

        int zeroIndex = index;
        int numIndex = index + 1;

        while (numIndex < nums.length) {
            while (numIndex < nums.length && nums[numIndex] == 0) {
                numIndex++;
            }
            if (numIndex == nums.length) break;
            nums[zeroIndex] = nums[numIndex];
            nums[numIndex] = 0;
            zeroIndex++;
        }
    }
}
