package com.helencoder.leetcode;

import java.util.*;

/**
 * Given an array of integers, return indices of the two
 * numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return[0, 1]
 *
 * Created by helencoder on 2018/1/2.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{11, 2, 7, 15};
        int target = 9;

        int[] indices = twoSum(nums, target);
        for (int indice : indices) {
            System.out.println(indice);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);

        }

        for (int num : nums) {
            if (numsMap.containsKey(target - num)) {
                indices[0] = numsMap.get(num);
                indices[1] = numsMap.get(target - num);
            }
        }

        Arrays.sort(indices);
        return indices;
    }
}
