package com.offermg.shl.hash;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class lc_2 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            char[] charS = s.toCharArray();
            Arrays.sort(charS);
            String sortS = new String(charS);
            if (map.get(sortS) == null) {
                List<String> strArray = new ArrayList<>();
                map.put(sortS, strArray);
            }
            map.get(sortS).add(s);
        }

        return map.values().stream().collect(Collectors.toList());
    }
}


class CustomCollector {
    public static void main(String[] args) {
        Stream<String> words = Stream.of("Java", "Stream", "Collector");

        // 手动实现一个带有 前缀"["、后缀"]"、逗号分隔"|" 的收集器
        String result = words.collect(Collector.of(
                // 1. Supplier: 初始化容器，先把前缀放进去
                () -> new StringBuilder("["),

                // 2. Accumulator: 定义如何添加元素
                (sb, s) -> {
                    if (sb.length() > 1) { // 如果不是刚开始（只有前缀），就加个分隔符
                        sb.append("|");
                    }
                    sb.append(s);
                },

                // 3. Combiner: 并行流时，如何合并两个 StringBuilder
                (sb1, sb2) -> {
                    // 如果 sb2 除了前缀还有内容，才合并
                    if (sb2.length() > 1) {
                        if (sb1.length() > 1) sb1.append("|");
                        sb1.append(sb2.substring(1)); // 跳过 sb2 的前缀进行合并
                    }
                    return sb1;
                },

                // 4. Finisher: 最后收尾，加上后缀并转为 String
                sb -> sb.append("]").toString()
        ));

        System.out.println(result); // 输出: [Java|Stream|Collector]
    }
}
