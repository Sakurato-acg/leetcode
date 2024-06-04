//package 数组;
//
//public class 双指针 {
//}
//
//class Solution {
//    public int maxArea(int[] height) {
//        int ans = 0;
//        int left = 0;
//        int right = height.length - 1;
//        while (left < right) {
//            int s = (right - left) * Math.min(height[left], height[right]);
//            ans = Math.max(ans, s);
//            if (height[left] < height[right]) {
//                left += 1;
//            } else {
//                right -= 1;
//            }
//        }
//        return ans;
//    }
//
//    public int trap(int[] height) {
//        int[] leftMax = new int[height.length];
//        int[] rightMax = new int[height.length];
//
//        int left=0;
//        int right=height.length-1;
//
//
//        while (left<right){
//            leftMax[left]=left>0?Math.max(height[left],leftMax[left-1]):height[left];
//            rightMax[right]=right<height.length-1?Math.max(height[right],rightMax[right+1]):height[right];
//            left++;
//            right--;
//        }
//    }
//}