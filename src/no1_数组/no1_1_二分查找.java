package no1_数组;

public class no1_1_二分查找 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.mySqrt(2);
        System.out.println("i = " + i);
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 请必须使用时间复杂度为 O(log n) 的算法。<br/>
     * <p>
     * 示例 1:<br/>
     * 输入: nums = [1,3,5,6], target = 5 <br/>
     * 输出: 2
     * </p>
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    // 34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else {
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        result[1] = right--;
        while (right >= 0) {
            if (nums[right] == target) {
                right--;
            } else {
                result[0] = right + 1;
                break;
            }
        }
        return result;
    }

    // 69. x的平方根 https://leetcode.cn/problems/sqrtx/description/
    public int mySqrt(int x) {
        if (x == 1) return 1;
        int left = 1;
        int right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }

    // 367.有效的完全平方数 https://leetcode.cn/problems/valid-perfect-square/description/
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int left = 1;
        int right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = (long) mid * mid;
            if (sum == num) return true;
            else if (sum < num) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return false;
    }
}