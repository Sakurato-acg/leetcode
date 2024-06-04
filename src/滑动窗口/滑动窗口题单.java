package 滑动窗口;

public class 滑动窗口题单 {
    public static void main(String[] args) throws Exception {
        Solution1 solution = new Solution1();
        int i = solution.divisorSubstrings(240, 2);
        System.out.println("i = " + i);
    }
}

class Solution1 {
    //1456. 定长子串中元音的最大数目 https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
    public int maxVowels(String s, int k) {
        int left = 0;
        int max = 0;
        int len = s.length();
        int count = 0;

        for (int right = 0; right < len; right++) {
            //想让窗口到达k
            if (right < k) {
                char charAt = s.charAt(right);
                count += isVowel(charAt);
            } else {
                max = Math.max(max, count);
                //左边界右移
                //如果是元音则减1
                char leftChar = s.charAt(left++);
                //算入右边界
                char rightChar = s.charAt(right);
                count += isVowel(rightChar) - isVowel(leftChar);
            }
        }
        return Math.min(max, count);
    }

    public int isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ? 1 : 0;
    }

    //2269. 找到一个数字的 K 美丽值 https://leetcode.cn/problems/find-the-k-beauty-of-a-number/
    public int divisorSubstrings(int num, int k) {
        String numStr = Integer.toString(num);
        int count = 0;
        for (int i = 0; i <= numStr.length() - k; i++) {
            // 截取长度为k的子字符串
            String subStr = numStr.substring(i, i + k);
            // 将子字符串转换为整数
            int subNum = Integer.parseInt(subStr);// 自动处理前导零，如Integer.parseInt("012")=12
            // 检查子字符串是否能整除num，同时避免除以0
            if (subNum != 0 && num % subNum == 0) {
                count++;
            }
        }
        return count;
    }

    //1984. 学生分数的最小差值
}