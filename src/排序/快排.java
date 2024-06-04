package 排序;

import java.util.ArrayList;
import java.util.List;

public class 快排 {
    public static void main(String[] args) {
        int[] arr = new int[]{19, 97, 9, 17, 1, 8};
        int i = findKthLargest(arr, 1);
        System.out.println("i = " + i);
    }

    private static int quickSelect(List<Integer> nums, int k) {
        // 随机选择基准数
        int pivot = nums.get(0);
        // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot)
                big.add(num);
            else if (num < pivot)
                small.add(num);
            else
                equal.add(num);
        }
        // 第 k 大元素在 big 中，递归划分
        if (k <= big.size())
            return quickSelect(big, k);
        // 第 k 大元素在 small 中，递归划分
        if (nums.size() - small.size() < k)
            return quickSelect(small, k - nums.size() + small.size());
        // 第 k 大元素在 equal 中，直接返回 pivot
        return pivot;
    }

    public static int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return quickSelect(numList, k);
    }

}
