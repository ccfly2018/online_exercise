package com.lk.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * @author 陆昆
 *
 * 注意: 题目假设所有元素都是不重复的,同时肯定有唯一一个解
 * @create 2018-01-06 下午3:11
 **/
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 22;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numIndexMap = new HashMap<Integer, Integer>();
        for (int i = 1; i < nums.length; i++) {
            numIndexMap.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            if (numIndexMap.containsKey(target - nums[j])) {
                result[0] = j;
                result[1] = numIndexMap.get(target - nums[j]);
                break;
            }
        }
        return result;
    }
}
