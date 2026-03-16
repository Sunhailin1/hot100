package com.offermg.shl.doublePoints;

public class lc_11 {
    public int maxArea(int[] height) {
        int maxAreaNum = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxAreaNum = Math.max(Math.min(height[left], height[right]) * (right - left), maxAreaNum);
            // 移动较短的一侧，才可能通过找到更高的边来增大面积
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxAreaNum;
    }
}
