package com.offermg.shl.array;

public class lc_53 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int preMin = 0;
        int ans = -10001;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = Math.max(ans, sum - preMin);
            preMin = Math.min(sum, preMin);
        }

        return ans;
    }
}
