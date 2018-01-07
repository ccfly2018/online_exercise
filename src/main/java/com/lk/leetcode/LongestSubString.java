package com.lk.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 3
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * 关键: 想到一个移动的窗口,窗口的起始位置和终止位置的改变以及窗口大小的记录,关注点当出现重窗口的起始位置移动多少
 * @author 陆昆
 * @create 2018-01-07 下午6:05
 **/
public class LongestSubString {
    public static void main(String[] args) {
        String test = "dvdf";
        System.out.println(lengthOfLongestSubstring(test));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int result = 0;
        Map<Character, Integer> indexMap = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; j < len; j++) {
            if (indexMap.containsKey(s.charAt(j))) {
                i = Math.max(indexMap.get(s.charAt(j)), i);
            }
            result = Math.max(result, j - i + 1);
            indexMap.put(s.charAt(j), j + 1);
        }
        return result;
    }
}
