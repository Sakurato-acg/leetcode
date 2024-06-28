package no1_数组;

public class no1_2_移除元素 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        boolean b = solution2.backspaceCompare("ab##", "c#d#");
        System.out.println("b = " + b);
    }
}

class Solution2 {
    // 27. 移除元素 https://leetcode.cn/problems/remove-element/
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    //[双指针,有序] 26. 删除有序数组中的重复项 https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] != nums[left]) {
                nums[left + 1] = nums[right];
                left++;
            }
            right++;
        }
        return left + 1;
    }

    //[双指针,无序] 283. 移动零到最后 https://leetcode.cn/problems/move-zeroes/description/
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

    //844. 比较含退格的字符串 https://leetcode.cn/problems/backspace-string-compare/description/

    /**
     * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。<br/>
     * 注意：如果对空文本输入退格字符，文本继续为空。<br/>
     * 示例 1：<br/>
     * 输入：s = "ab#c", t = "ad#c" <br/>
     * 输出：true <br/>
     * 解释：s 和 t 都会变成 "ac"。
     */
    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#' && s1.length() > 0) {
                s1.deleteCharAt(s1.length() - 1);
            } else s1.append(s.charAt(i));
        }
        StringBuilder t1 = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#' && t1.length() > 0) {
                t1.deleteCharAt(t1.length() - 1);
            } else t1.append(t.charAt(i));
        }
        return s1.toString().contentEquals(t1);
    }
}