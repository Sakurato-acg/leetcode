package 滑动窗口;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.cn/circle/discuss/0viNMK/
public class 滑动窗口题单 {
    public static void main(String[] args) throws Exception {
        Solution1 solution = new Solution1();
        solution.getSubarrayBeauty(new int[]{1,-1,-3,-2,3}, 3, 2);
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

    //1984. 学生分数的最小差值 https://leetcode.cn/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/
    public int minimumDifference(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
    }

    //1343. 大小为 K 且平均值大于等于阈值的子数组数目 https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i - k >= -1) {
                if (sum / k >= threshold) {
                    ans++;
                }
                sum -= arr[i - k + 1];
            }
        }
        return ans;
    }

    //2090. 半径为 k 的子数组平均值 https://leetcode.cn/problems/k-radius-subarray-averages/description/
    public int[] getAverages(int[] nums, int k) {
        int[] arr = new int[nums.length];
        long sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            arr[right] = -1;
            if (right >= 2 * k) {
                if (k == 0) {
                    arr[(left + right) / 2] = (int) sum;
                } else {
                    arr[(left + right) / 2] = (int) (sum / (2 * k + 1));
                }
                sum -= nums[left++];
            }
        }
        return arr;
    }

    //2379. 得到 K 个黑块的最少涂色次数  https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/
    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;

        for (int right = 0; right < blocks.length(); right++) {
            char str = blocks.charAt(right);
            if (str == 'W') count++;
            if (right >= k - 1) {
                min = Math.min(min, count);
                if (blocks.charAt(left++) == 'W' && count > 0) count--;
            }
        }
        return min;
    }

    //1052. 爱生气的书店老板
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left = 0;
        int n = customers.length;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int sum = 0;
        int result = 0;
        for (int right = 0; right < n; right++) {
            sum += grumpy[right] == 1 ? customers[right] : 0;
            result += grumpy[right] == 0 ? customers[right] : 0;
            if (right >= minutes - 1) {
                if (sum > max) {
                    minIndex = left;
                    max = sum;
                }
                sum -= grumpy[left] == 1 ? customers[left] : 0;
                left++;
            }
        }

        for (int i = 0; i < minutes; i++, minIndex++) {
            result += grumpy[minIndex] == 1 ? customers[minIndex] : 0;
        }
        return result;
    }

    //2841. 几乎唯一子数组的最大和 https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray/description/
    public long maxSum(List<Integer> nums, int m, int k) {
        //滑动窗口，可以用Map表快速得知当前窗口不同数的数量是否达标，同时利用一个变量维护窗口总值
        if (k < m) return 0;//至少有m个不同，如果k的个数都达不到m个，直接返回0
        Integer[] ar = nums.toArray(new Integer[nums.size()]);
        //toArray方法，集合变数组，toArray(new Integer[nums.size()])
        //存放滑动窗口中的数，利用不重复的性质存储不同数的数量
        HashMap<Integer, Integer> map = new HashMap<>();
        //i-j为窗口
        int i = 0, j = k - 1, n = ar.length;
        //max为符合要求的窗口中的最大值，mx为当前窗口总值
        long max = 0, mx = 0;
        //给map和mx赋初值
        for (int p = 0; p < j; p++) {//[0,k-1)先在窗口中
            mx += ar[p];
            map.put(ar[p], map.getOrDefault(ar[p], 0) + 1);//统计窗口中的元素频率
        }
        //开始滑
        for (; j < n; i++, j++) {//k-1<n
            //窗口尾部添加

            if (!map.containsKey(ar[j])) {
                map.put(ar[j], 1);
            } else {
                map.put(ar[j], map.get(ar[j]) + 1);
            }
            mx += (ar[j]);
            if (map.size() >= m) {
                //map.size代表着不同元素的数量，相同的话已经在自己的key上+1
                //如果满足条件则更新最大值
                max = Math.max(max, mx);
            }
            //窗口首部弹出
            mx = mx - ar[i];
            if (map.get(ar[i]) == 1)
                map.remove(ar[i]);
            else map.put(ar[i], map.get(ar[i]) - 1);
        }
        return max;
    }

    //2461. 长度为 K 子数组中的最大和 https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length, i = 0, j = 0;
        long ans = 0, sum = 0;
        while (j < n) {
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i++];
            }
            set.add(nums[j]);
            sum += nums[j];
            if (j - i + 1 == k) {
                ans = Math.max(sum, ans);
                sum -= nums[i];
                set.remove(nums[i++]);
            }
            j++;
        }
        return ans;
    }

    //1423. 可获得的最大点数 https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        for (int left = 0; left <= k; left++) {
            int sum = 0;
            int i = 0;
            while (i < left) {
                sum += cardPoints[i];
                i++;
            }
            int right = k - left;
            int j = 0;
            while (j < right) {
                sum += cardPoints[cardPoints.length - 1 - j];
                j++;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    //2653. 滑动子数组的美丽值 https://leetcode.cn/problems/sliding-subarray-beauty/
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index = 0;

        List<Integer> list = new ArrayList<>(k);

        for (int right = 0; right < n; right++) {
            list.add(nums[right]);
            if (right >= k - 1) {
                Integer min = list.parallelStream().sorted().collect(Collectors.toList()).get(x - 1);
                result[index++] = min < 0 ? min : 0;
                list.remove(0);
            }
        }
        return result;

    }

}