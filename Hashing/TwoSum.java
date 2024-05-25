package Hashing;
// Given an array of integers nums and an integer target, return 
// indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution,
// and you may not use the same element twice.
// You can return the answer in any order.
import java.util.*;
class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{-1, -1}; // No solution found
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6};
        int target = 9;

        int[] ans = twoSum(nums, target);

        System.out.println(ans[0] + " " + ans[1] + " ");
        
    }
}