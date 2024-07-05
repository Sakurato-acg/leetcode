package hot100.no_11_二分查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        double i = solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println("i = " + i);
    }
}

class Solution {
    public int binarySearch(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    // 74. 搜索二维矩阵 https://leetcode.cn/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-100-liked
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int index = binarySearch(matrix[i], target);
            if (index < matrix[i].length && matrix[i][index] == target) return true;
        }
        return false;
    }

    // 34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target);
        if (left < nums.length && nums[left] == target) {
            int right = binarySearch(nums, target + 1) - 1;
            return new int[]{left, right};
        } else {
            return new int[]{-1, -1};
        }
    }

    // 33. 搜索旋转排序数组 https://leetcode.cn/problems/search-in-rotated-sorted-array/?envType=study-plan-v2&envId=top-100-liked
    public int search(int[] nums, int target) {
        int min = findMin(nums);
        if (min != 0) {
            int left = binarySearch(nums, target, 0, min - 1);
            if (left < min && nums[left] == target) return left;
        }
        int right = binarySearch(nums, target, min, nums.length - 1);
        if (right < nums.length && nums[right] == target) return right;
        return -1;
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 2;
        int end = nums[nums.length - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < end) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(nums1).forEach(list::add);
        Arrays.stream(nums2).forEach(list::add);
        list.sort((o1, o2) -> o1-o2);


        int left = 0;
        int right = list.size() - 1;
        int mid = left + (right - left) / 2;
        if (list.size() / 2 == 1) {
            return list.get(mid) * 1.0;
        }else{
            return (list.get(mid)+list.get(mid+1))*1.0/2;
        }

    }
}


