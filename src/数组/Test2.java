package 数组;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
//        String[]arr=new String[]{"eat","tea","tan","ate","nat","bat"};
//        List<List<String>> lists = new Test2().groupAnagrams(arr);
//
//        lists.forEach(System.out::println);
        int []arr=new int[]{0,3,7,2,5,8,4,6,0,1};
        int i = new Test2().longestConsecutive(arr);
        System.out.println("i = " + i);
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        Arrays.sort(nums);
        int count=1;
        int max=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                count++;
            }else{
                if(count>max){
                    max=count;
                }
                count=1;
            }
        }
        if(count>max){
            max=count;
        }
        return max;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
