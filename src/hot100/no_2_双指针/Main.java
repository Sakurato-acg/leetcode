package hot100.no_2_双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }
}

class Solution {
    // 283. 移动零 https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
    public void moveZeroes(int[] nums) {
        // 定义2个指针，一个指针用于遍历，另一个指针用于记录非零元素的最大索引
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 11. 盛最多水的容器 https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, (right - left + 1) * Math.max(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right++;
            }
        }
        return max;
    }

    // 15. 三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList();
        for (int i = 0; i < nums.length - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue;

            if (x + nums[i + 1] + nums[i + 2] > 0) break;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                //当前的三数之和
                int s = x + nums[j] + nums[k];

                if (s > 0) {
                    //右边界-1
                    k -= 1;
                } else if (s < 0) {
                    j += 1;
                } else {
                    List temp = new ArrayList();
                    temp.add(x);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    list.add(temp);
                    //相同数字的情况
                    j += 1;
                    while (j < k && nums[j] == nums[j - 1]) j += 1;
                    k -= 1;
                    while (j < k && nums[k] == nums[k + 1]) k -= 1;
                }
            }
        }
        return list;
    }

    // 42. 接雨水
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0]=height[0];
        suf[n-1]=height[n-1];

        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(height[i], pre[i - 1]);
            suf[n - 1 - i] = Math.max(height[n - 1 - i], suf[n - i]);
        }

        for (int i = 0; i < n; i++) {
            ans += Math.min(pre[i], suf[i]) - height[i];
        }
        return ans;
    }

}