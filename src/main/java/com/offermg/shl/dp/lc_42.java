package com.offermg.shl.dp;

public class lc_42 {
    public int trap(int[] height) {
        int[] dpLeft = new int[height.length];

        int max = -1;
        for (int i = 0; i < height.length; i++) {
            max = max > height[i] ? max: height[i];
            dpLeft[i] = max;
        }

        int contains = 0;
        max = -1;
        for (int i = height.length - 1; i >= 0; i--) {
            max = max > height[i] ? max: height[i];
            contains += Math.min(max, dpLeft[i]) - height[i];
        }

        return contains;
    }
}
