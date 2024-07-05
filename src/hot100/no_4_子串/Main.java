package hot100.no_4_子串;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        queue.add(2);
        queue.add(-1);
        System.out.println("queue.poll() = " + queue.poll());

        Solution solution = new Solution();
        int[] i = solution.maxSlidingWindow(new int[]{3, 1, -1, 2}, 3);
        System.out.println("i = " + Arrays.toString(i));
    }
}

class Solution {
    // 560. 和为 K 的子数组 https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked
    // 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
    public int subarraySum(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int result = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            if (sum == k) {
                sum -= nums[left++];
                result++;
            } else if (sum > k) {
                while (sum > k) {
                    sum -= nums[left++];
                    if (sum == k && left < nums.length) {
                        if (left < nums.length - 1) sum -= nums[left++];
                        result++;
                    }
                }
            }
        }
        return result;
    }

    // 239. 滑动窗口最大值 https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int left = 0;
        Deque<Integer> q = new ArrayDeque<>(); // 双端队列
        for (int i = 0; i < n; i++) {
            // 1. 入
            while (!q.isEmpty() && nums[i] >= nums[q.getLast()]) {
                q.removeLast(); // 维护 q 的单调性
            }
            q.addLast(i); // 入队
            // 2. 出
            if (i - q.getFirst() >= k) { // 队首已经离开窗口了
                q.removeFirst();
            }
            // 3. 记录答案
            if (i >= k - 1) {
                // 由于队首到队尾单调递减，所以窗口最大值就是队首
                ans[left++] = nums[q.getFirst()];
            }
        }
        return ans;
    }
}
