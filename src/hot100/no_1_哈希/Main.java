package hot100.no_1_哈希;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestConsecutive(new int[]{100, 4, 200, 1, 3,});
    }
}

class Solution {

    // 1. 两数之和 https://leetcode.cn/problems/two-sum/?envType=study-plan-v2&envId=top-100-liked
    // 输入：nums = [3,2,4], target = 6
    // 输出：[1,2]
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(target - key)) {
                return new int[]{map.get(target - key), i};
            }
            map.put(key, i);
        }
        return new int[]{-1, -1};
    }

    // 49. 字母异位词分组 https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked
    // 示例 1:
    // 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    // 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    //128. 最长连续序列 https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
    //输入：nums = [0,3,7,2,5,8,4,6,0,1]
    //输出：9
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
