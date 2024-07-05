package hot100.no_3_滑动窗口;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    // 3. 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            char key = s.charAt(right);
            if (map.containsKey(key)) {
                max = Math.max(max, right - left);
                left = Math.max(left, map.get(key)+1);
                map.remove(key);
            }
            map.put(key, right);
        }
        return max;
    }

    // 438. 找到字符串中所有字母异位词 https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
    public List<Integer> findAnagrams(String s, String p) {
        //n是大的一方，m是小的一方
        int n = s.length(), m = p.length();
        List<Integer> result = new ArrayList<>();

        if (n < m) {
            return result;
        }

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < m; ++i) {
            cnt1[s.charAt(i) - 'a']++;
            cnt2[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2)) {
            result.add(0);
        }
        for (int i = m; i < n; ++i) {
            cnt1[s.charAt(i) - 'a']++;
            cnt1[s.charAt(i - m) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) {
                result.add(i - m + 1);
            }
        }
        return result;
    }}