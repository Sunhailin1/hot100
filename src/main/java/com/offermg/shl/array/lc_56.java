package com.offermg.shl.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lc_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        List<int[]> ansList = new ArrayList<>();
        int curStart = intervals[0][0];
        int curEnd = intervals[0][0];
        for (int[] nums: intervals) {
            if (curEnd >= nums[0]) {
                curEnd = Math.max(nums[1], curEnd);
            } else {
                int[] newInterval = new int[2];
                newInterval[0] = curStart;
                newInterval[1] = curEnd;
                curStart = nums[0];
                curEnd = nums[1];
                ansList.add(newInterval);
            }
        }

        int[] newInterval = new int[2];
        newInterval[0] = curStart;
        newInterval[1] = curEnd;
        ansList.add(newInterval);

        return ansList.toArray(new int[0][]);
    }
}
