package no1_数组;

import java.util.Arrays;

public class no1_3_有序数组的平方 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] ints = solution3.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println("ints = " + Arrays.toString(ints));
    }
}

class Solution3 {
    //977. 有序数组的平方 https://leetcode.cn/problems/squares-of-a-sorted-array/description/
    //输入：nums = [-4,-1,0,3,10]
    //输出：[0,1,9,16,100]
    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                // 正数的相对位置是不变的， 需要调整的是负数平方后的相对位置
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }


}
