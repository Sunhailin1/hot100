package com.offermg.shl.hash;

import java.util.HashSet;
import java.util.Set;

public class lc_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        int maxLength = 0;
        Set<Integer> record = new HashSet<>();

        for (int num: nums) {
            if (set.contains(num + 1) || record.contains(num)) {
                continue;
            } else {
                record.add(num);
                int curNum = num - 1;
                int curLength = 1;
                while (set.contains(curNum)) {
                    curLength++;
                    curNum-=1;
                }

                maxLength = maxLength < curLength ? curLength: maxLength;
                if (maxLength > nums.length / 2) {
                    break;
                }
            }
        }

        return maxLength;
    }
}
