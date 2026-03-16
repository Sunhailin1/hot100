package com.offermg.shl.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc_1 {
    public static void main(String[] args) {

    }


    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                ArrayList<Integer> newArray = new ArrayList<>();
                newArray.add(i);
                map.put(nums[i], newArray);
            } else {
                map.get(nums[i]).add(i);
            }
        }

        if (target % 2 == 0 && map.get(target / 2) != null && map.get(target / 2).size() > 1) {
            ans[0] = map.get(target / 2).get(0);
            ans[1] = map.get(target / 2).get(1);

            return ans;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            if (nums[left] + nums[right] == target) {
                ans[0] = map.get(nums[left]).get(0);
                ans[1] = map.get(nums[right]).get(0);

                return ans;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }

    public int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (record.get(target - nums[i]) != null) {
                ans[1] = i;
                ans[0] = record.get(target - nums[i]);

                return ans;
            }

            record.put(nums[i], i);
        }

        return ans;
    }
}
