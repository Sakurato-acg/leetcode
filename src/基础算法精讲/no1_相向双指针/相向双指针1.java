package 基础算法精讲.no1_相向双指针;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings(value = "")
public class 相向双指针1 {
    // https://github.com/EndlessCheng/codeforces-go/blob/master/leetcode/README.md
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.triangleNumber(new int[]{2, 2, 3, 4});
        System.out.println("i = " + i);
    }
}

class Solution {
    //167. 两数之和 II - 输入有序数组 https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/

    /**
     * 子元素和
     * 核心：有序
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (true) {
            int s = numbers[left] + numbers[right];
            if (s == target) {
                return new int[]{left + 1, right + 1}; // 题目要求下标从 1 开始
            }
            if (s > target) {
                right--;
            } else {
                left++;
            }
        }
    }

    //15. 三数之和 https://leetcode.cn/problems/3sum/

    /**
     * 子元素和 <br/>
     * 核心：先有序，当成两数之和
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList();
        for (int i = 0; i < nums.length - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue;

            if (x + nums[i + 1] + nums[i + 2] > 0) break;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                //当前的三数之和
                int s = x + nums[j] + nums[k];

                if (s > 0) {
                    //右边界-1
                    k -= 1;
                } else if (s < 0) {
                    j += 1;
                } else {
                    List temp = new ArrayList();
                    temp.add(x);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    list.add(temp);
                    //相同数字的情况
                    j += 1;
                    while (j < k && nums[j] == nums[j - 1]) j += 1;
                    k -= 1;
                    while (j < k && nums[k] == nums[k + 1]) k -= 1;
                }
            }
        }
        return list;
    }

    //2824. 统计和小于目标的下标对数目 https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/

    /**
     * 子元素和 <br/>
     * 核心：先有序，当成两数之和
     */
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int ans = 0;
        int left = 0;
        int right = nums.size() - 1;

        // -1,1,1,2,3
        while (left < right) {
            int i = nums.get(left);
            int j = nums.get(right);
            if (i + j >= target) {
                right--;
            } else {
                ans += right - left;
                left++;
            }
        }

        return ans;

    }

    // 16. 最接近的三数之和 https://leetcode.cn/problems/3sum-closest/
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            // 双指针
            int j = i + 1, k = n - 1;
            while (j < k) {
                int s = x + nums[j] + nums[k];
                if (s == target) {
                    return target;
                }
                if (s > target) {
                    if (s - target < minDiff) { // s 与 target 更近
                        minDiff = s - target;
                        ans = s;
                    }
                    k--;
                } else { // s < target
                    if (target - s < minDiff) { // s 与 target 更近
                        minDiff = target - s;
                        ans = s;
                    }
                    j++;
                }
            }
        }
        return ans;
    }

    // 611. 有效三角形的个数 https://leetcode.cn/problems/valid-triangle-number/description/

    /**
     * 逆序三数之和
     */
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int a = 0, b = n - 2, c = n - 1;
        int res = 0;
        while (c >= 2) {
            a = 0;
            b = c - 1;
            while (a < b) {
                if (nums[a] + nums[b] > nums[c]) {
                    res += b - a;
                    b--;
                } else {
                    a++;
                }
            }
            c--;
        }
        return res;
    }

}

