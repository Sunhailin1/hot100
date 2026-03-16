package com.offermg.shl.doublePoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int lastNum = 100001;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (nums[i] == lastNum) continue;

            lastNum = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            if (nums[i] + 2 * nums[left] > 0) break;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    while(left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                } else {
                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                }
            }
        }

        return ans;
    }
}
