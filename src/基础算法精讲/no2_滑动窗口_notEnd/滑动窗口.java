package 基础算法精讲.no2_滑动窗口_notEnd;

import java.util.HashMap;
import java.util.Map;

public class 滑动窗口 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring(" ");
    }
}

class Solution {
    // 209. 长度最小的子数组 https://leetcode.cn/problems/minimum-size-subarray-sum/description/
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            ans += nums[right];
            while (ans >= target) {
                min = Math.min(min, right - left + 1);
                ans -= nums[left++];
            }
        }
        return left == 0 ? 0 : min;
    }

    // 3. 无重复字符的最长子串 https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = Integer.MIN_VALUE;
        int right;
        for (right = 0; right < s.length(); right++) {
            char key = s.charAt(right);
            if (map.containsKey(key)) {
                max = Math.max(max, right - left);
                int tmp = left;
                left = Math.max(map.get(key) + 1, left);
                while (tmp < left) {
                    map.remove(s.charAt(tmp++));
                }
            }
            map.put(key, right);
        }
        return Math.max(max, right - left);
    }
}
