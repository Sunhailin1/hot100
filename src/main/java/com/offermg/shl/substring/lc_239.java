package com.offermg.shl.substring;

import java.util.ArrayDeque;
import java.util.Queue;

public class lc_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] queue = new int[nums.length];
        int curLast = -1;
        int curFirst = 0;
        int[] ans = new int[nums.length - k + 1];
        // 初始化
        for (int i = 0; i < k; i++) {
            while (curLast >= curFirst && queue[curLast] < nums[i]) {
                curLast--;
            }
            queue[++curLast] = nums[i];
        }

        ans[0] = queue[curFirst];
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == queue[curFirst]) {
                curFirst++;
            }
            while (curLast >= curFirst && queue[curLast] < nums[i]) {
                curLast--;
            }
            queue[++curLast] = nums[i];

            ans[i-k+1] = queue[curFirst];
        }

        return ans;
    }
}
