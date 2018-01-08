package com.helencoder.leetcode.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 *
 * Example:
 *  Input: "babad"
 *  Output: "bab"
 *  Note: "aba" is also a valid answer.
 *
 * Example:
 *  Input: "cbbd"
 *  Output: "bb"
 *
 * Created by zhenghailun on 2018/1/8.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        longestPalindrome(s);
    }

    // failed by "cbbd"
    public static String longestPalindrome(String s) {
        String res = "";

        char[] charArray = s.toCharArray();
        // reverse the str
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            sb.insert(0, c);
        }
        String reverseStr = sb.toString();

        Set<String> set = new HashSet<String>();
        int len = charArray.length;
        for (int i = 0; i < charArray.length; i++) {
            if (s.substring(0, i+1).equals(reverseStr.substring(len-i-1))) {
                set.add(s.substring(0, i+1));
            }
        }

        for (String str : set) {
            res = str.length() > res.length() ? str : res;
        }

        return res;
    }
}
