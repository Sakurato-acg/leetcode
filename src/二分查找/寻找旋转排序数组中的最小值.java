package 二分查找;

public class 寻找旋转排序数组中的最小值 {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 2;
        int n = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[n]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }
}
