package com.offermg.shl.substring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc_76 {
    public String minWindow(String s, String t) {
        // 如果s比t短，不可能存在最小覆盖子串，返回空字符串
        if (s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            set.add(c);
        }

        int right = 0;
        int left = 0;
        int[] minIndex = new int[2];
        int minLength = 100001;
        while (right < s.length() || set.isEmpty()) {
            if (set.isEmpty()) {
                if (right - left < minLength) {
                    minLength = right - left;
                    minIndex[0] = left;
                    minIndex[1] = right;
                }
                if (map.get(s.charAt(left)) != null) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if (map.get(s.charAt(left)) > 0) {
                        set.add(s.charAt(left));
                    }
                }

                left++;
            } else {
                if (map.get(s.charAt(right)) != null) {
                    map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                    if (map.get(s.charAt(right)) <= 0) {
                        set.remove(s.charAt(right));
                    }
                }

                right++;
            }
        }

        return s.substring(minIndex[0], minIndex[1]);
    }
}
