package hot100.no_17_技巧;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.singleNumber(new int[]{1, 2, 1});
        System.out.println("i = " + i);
    }
}

class Solution {

    // 异或
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            ans ^= x;
        }
        return ans;
    }

    // 求出现次数大于 n/2 的数
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 0;
        for (int n : nums) {
            if (res == n) {
                count++;
            } else {
                count--;
                if (count <= 0) {
                    res = n;
                    count = 1;
                }
            }
        }
        return res;
    }

    // 75. 颜色分类 https://leetcode.cn/problems/sort-colors/description/?envType=study-plan-v2&envId=top-100-liked
    public void sortColors(int[] nums) {
        int n0 = 0, n1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            nums[i] = 2;
            if (num < 2) {
                nums[n1++] = 1;
            }
            if (num < 1) {
                nums[n0++] = 0;
            }
        }
    }
}
