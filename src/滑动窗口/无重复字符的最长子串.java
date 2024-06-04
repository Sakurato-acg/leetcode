package 滑动窗口;

import java.util.HashMap;

@SuppressWarnings("all")
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("bbbbbbb");
        System.out.println("i = " + i);
    }

    public static int lengthOfLongestSubstring(String s) {
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
}
