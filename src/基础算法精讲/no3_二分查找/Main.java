package 基础算法精讲.no3_二分查找;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countFairPairs(new int[]{0,0,0,0,0,0}, -10, 10);
    }
}

class Solution {
    // 34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-zong-shi-xie-bu-dui-yi-g-t9l9/
    public int binarySearch(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left++;
            } else {
                right--;
            }
        }
        return left;
    }

    // 2529. 正整数和负整数的最大计数 https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/description/
    public int maximumCount(int[] nums) {
        int neg = binarySearch(nums, 0);
        int pos = nums.length - binarySearch(nums, 1);
        return Math.max(neg, pos);
    }

    // https://leetcode.cn/problems/count-the-number-of-fair-pairs/
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
//            if (cur > upper || cur > lower) continue;
            int left = binarySearch(nums, lower - cur, i+1, nums.length - 1);
            int right = binarySearch(nums, upper - cur + 1, i+1, nums.length - 1) - 1;

            if (left <= right) {
                count += right - left + 1;
            }
        }
        return count;
    }


}






