package com.helencoder.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Created by zhenghailun on 2018/1/4.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        //String s = "abcabcbb";
        //String s = "bbbbb";
        //String s = "pwwkew";
        //String s = "dvdf";
        String s = "asjrgapa";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int length = 0;
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < charArray.length; i++) {
            if (!list.contains(String.valueOf(charArray[i]))) {
                list.add(String.valueOf(charArray[i]));
                length = list.size() > length ? list.size() : length;
            } else {

                list.clear();
                list.add(String.valueOf(charArray[i]));
            }
        }

        int rve_length = 0;
        List<String> rev_list = new ArrayList<String>();
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (!rev_list.contains(String.valueOf(charArray[i]))) {
                rev_list.add(String.valueOf(charArray[i]));
                rve_length = rev_list.size() > rve_length ? rev_list.size() : rve_length;
            } else {
                rev_list.clear();
                rev_list.add(String.valueOf(charArray[i]));
            }
        }

        return length >= rve_length ? length : rve_length;
    }

}
