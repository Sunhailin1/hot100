package com.offermg.shl.sliceWindow;

import com.sun.source.tree.NewArrayTree;

import java.util.*;

public class lc_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        int[] map = new int[26];

        if (s.length() < p.length())
            return ans;

        for (char c: p.toCharArray()) {
            map[c-'a']++;
            set.add(c);
        }

        int left = 0;
        int right = p.length();
        for (int i = 0; i < p.length(); i++) {
            if (--map[s.charAt(i)-'a'] == 0){
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        if (set.isEmpty()) {
            ans.add(left);
        }

        while (right < s.length()) {
            if (++map[s.charAt(left)-'a'] == 0) {
                set.remove(s.charAt(left));
            } else {
                set.add(s.charAt(left));
            }
            left++;

            if (--map[s.charAt(right)-'a'] == 0) {
                set.remove(s.charAt(right));
            } else {
                set.add(s.charAt(right));
            }
            right++;

            if (set.isEmpty()) {
                ans.add(left);
            }
        }

        return ans;
    }
}
