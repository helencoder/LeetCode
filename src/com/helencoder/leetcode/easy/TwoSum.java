package com.helencoder.leetcode.easy;

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
        int[] nums = new int[]{3, 2, 4};
//        int[] nums = new int[]{2, 2, 7, 15};
        int target = 6;

        int[] indices = twoSum1(nums, target);
        for (int indice : indices) {
            System.out.println(indice);
        }
    }

    // ignore two same elements testcase
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

    // eg: nums = [3, 2, 4] target = 6
    // java.lang.ArrayIndexOutOfBoundsException
    public static int[] twoSum1(int[] nums, int target) {
        int[] indices = new int[2];
        List<Integer> numsList = new ArrayList<Integer>();

        for (int num : nums) {
            numsList.add(num);
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (numsList.contains(target- nums[i])) {
                indices[index] = i;
                index++;
            }
        }

        Arrays.sort(indices);
        return indices;
    }

    // accepted
    public static int[] twoSum2(int[] nums, int target) {
        int[] indices = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                indices[0] = map.get(nums[i]);
                indices[1] = i;
                break;
            }
        }
        return indices;
    }

    // accepted
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
