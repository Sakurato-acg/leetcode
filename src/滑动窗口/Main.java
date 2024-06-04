package 滑动窗口;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        long i = solution.countSubarrays(new int[]{1, 3, 2, 3, 3}, 2);
//        System.out.println("i = " + i);
    }
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = 0;
        //数组长度
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            ans += nums[right];
            right++;
            while (ans >= target) {
                min = Math.min(min, right - left);
                ans -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int ans = 0, left = 0;
        int i;
        for (i = 0; i < s.length(); ++i) {
            char cur = s.charAt(i);
            if (hash.containsKey(cur)) {
                ans = Math.max(ans, i - left);
                left = Math.max(left, hash.get(cur) + 1);
            }
            hash.put(cur, i);
        }
        return Math.max(ans, i - left);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int n = nums.length;
        int sum = 1;
        int count = 0;

        for (int right = 0; right < n; right++) {
            sum *= nums[right];
            if (sum < k) {
                count += right - left + 1;
            } else {
                while (left <= right && sum >= k) {
                    sum /= nums[left++];
                }
                count += right - left + 1;
            }
        }
        return count;
    }

    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0, left = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            int now = nums[right];

            if (cnt.containsKey(now)) {
                cnt.put(now, cnt.get(now) + 1);
            } else {
                cnt.put(now, 1);
            }
            while (cnt.get(now) > k) {
                if (cnt.containsKey(nums[left])) {
                    cnt.put(nums[left], cnt.get(nums[left]) - 1);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    // https://leetcode.cn/problems/find-the-longest-semi-repetitive-substring/
    public int longestSemiRepetitiveSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        List<Integer> list = new ArrayList<>(2);
        int left = 0;
        int ans = 0;
        int count = 0;
        for (int right = 1; right < s.length(); right++) {
            char c1 = s.charAt(right - 1);
            char c2 = s.charAt(right);
            if (c2 == c1) {
                list.add(right);
                count++;
            }
            if (count == 2) {
                left = list.get(0);
                list.remove(0);
                count--;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    // 最大连续1的个数 III https://leetcode.cn/problems/max-consecutive-ones-iii/
    public int longestOnes(int[] nums, int k) {
        int ans = 0, left = 0, cnt0 = 0;
        for (int right = 0; right < nums.length; right++) {
            cnt0 += 1 - nums[right]; // 0 变成 1，用来统计 cnt0
            while (cnt0 > k) {
                cnt0 -= 1 - nums[left++];
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;

    }

//    public long countSubarrays(int[] nums, int k) {
//        int mx = Arrays.stream(nums).max().getAsInt();
//
//        int left = 0, ans = 0, n = nums.length, count = 0;
//        for (int right = 0; right < n; right++) {
//            if (nums[right]==mx){
//                count++;
//            }
//            while (count>=k){
//                ans+=n-right;
//                if ()
//            }
//        }
//
//    }

}