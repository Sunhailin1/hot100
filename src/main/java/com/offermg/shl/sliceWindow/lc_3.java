package com.offermg.shl.sliceWindow;

import java.util.HashSet;
import java.util.Set;

public class lc_3 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            right++;
            set.add(c);
            maxLength = Math.max(right - left, maxLength);
        }

        return maxLength;
    }
}
