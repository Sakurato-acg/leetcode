package no1_数组;

public class no1_4_长度最小的子数组 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        solution4.minSubArrayLen(4, new int[]{1, 4, 4});
    }
}

class Solution4 {

    //209. 长度最小的子数组 https://leetcode.cn/problems/minimum-size-subarray-sum/description/
    //给定一个含有 n 个正整数的数组和一个正整数 target
    //找出该数组中满足其总和大于等于 target 的长度最小的子数组
    // [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            if (sum >= target) {
                min = Math.min(min, right - left);
                while (sum >= target) {
                    sum -= nums[left++];
                }
            }
        }
        return min;
    }
}

