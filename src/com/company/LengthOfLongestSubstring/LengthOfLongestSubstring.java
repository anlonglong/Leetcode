package com.company.LengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println("lengthOfLongestSubstring() = " + lengthOfLongestSubstring("abccbasd"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                start = Math.max(map.get(ch)+1,start);
            }
            map.put(ch,end);
            max = Math.max(max,end - start + 1);
        }
        return max;
    }
}
