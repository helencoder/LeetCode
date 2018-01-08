package com.helencoder.leetcode.hard;

import java.util.Arrays;
import java.util.List;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 *  nums1 = [1, 3]
 *  nums2 = [2]
 *  The median is 2.0
 *
 * Example 2:
 *  nums1 = [1, 2]
 *  nums2 = [3, 4]
 *  The median is (2 + 3)/2 = 2.5
 *
 * Created by zhenghailun on 2018/1/7.
 */
public class MedianofTwoSortedArrays {

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 3};
        int[] num2 = new int[]{2};
        findMedianSortedArrays(num1, num2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;

        // combine two arrays
        int len = nums1.length + nums2.length;
        int[] combineArrays = new int[len];

        System.arraycopy(nums1, 0, combineArrays, 0, nums1.length);
        System.arraycopy(nums2, 0, combineArrays, nums1.length, nums2.length);

        // sort the combine arrays
        Arrays.sort(combineArrays);

        if (len % 2 == 0) {
            res = (combineArrays[len / 2] + combineArrays[len / 2 - 1]) / 2.0;
        } else {
            res = combineArrays[len / 2];
        }

        return res;
    }
}
