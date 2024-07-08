package 基础算法精讲.no1_相向双指针;


// https://github.com/EndlessCheng/codeforces-go/blob/master/leetcode/README.md
public class 相向双指针2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
    }
}

class Solution2 {
    // 11. 盛最多水的容器 https://leetcode.cn/problems/container-with-most-water/
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(ans, area);
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return ans;

    }

    // 42. 接雨水 https://leetcode.cn/problems/trapping-rain-water/
    public int trap(int[] height) {
        int n = height.length;
        int[] preMax = new int[n]; // preMax[i] 表示从 height[0] 到 height[i] 的最大值
        preMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }

        int[] sufMax = new int[n]; // sufMax[i] 表示从 height[i] 到 height[n-1] 的最大值
        sufMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(preMax[i], sufMax[i]) - height[i]; // 累加每个水桶能接多少水
        }
        return ans;
    }

}

