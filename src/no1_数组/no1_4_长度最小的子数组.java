package no1_数组;

public class no1_4_长度最小的子数组 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        solution4.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }
}

class Solution4 {

    //209. 长度最小的子数组 https://leetcode.cn/problems/minimum-size-subarray-sum/description/
    //给定一个含有 n 个正整数的数组和一个正整数 target
    //找出该数组中满足其总和大于等于 target 的长度最小的子数组
    // [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            ans += nums[right];
            sum += nums[right];
            if (sum >= target) {
                while (sum >= target) {
                    min = Math.min(min, right - left + 1);
                    sum -= nums[left++];
                }

            }
        }
        return ans >= target ? min : 0;
    }

    // 76. 最小覆盖子串
}

