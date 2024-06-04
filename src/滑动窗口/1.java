//package 刷题;
//
//import java.util.*;
//
//public class findmax {
//    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        Solution solution = new Solution();
//        String pwwkew = solution.minWindow("bbaa", "aba");
//        System.out.println(pwwkew);
//        long end = System.currentTimeMillis();
//        System.out.println(end-start+"ms");
//    }
//}
//class Solution {
//    Map<Character, Integer> ori = new HashMap<Character, Integer>();
//    Map<Character, Integer> cnt = new HashMap<Character, Integer>();
//
//    public String minWindow(String s, String t) {
//        int tLen = t.length();
//        for (int i = 0; i < tLen; i++) {
//            char c = t.charAt(i);
//            ori.put(c, ori.getOrDefault(c, 0) + 1);
//        }
//        int left= 0, right = -1;
//        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
//        int sLen = s.length();
//        while (r < sLen) {
//            ++r;
//            if (r < sLen && ori.containsKey(s.charAt(r))) {
//                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
//            }
//            while (check() && l <= r) {
//                if (r - l + 1 < len) {
//                    len = r - l + 1;
//                    ansL = l;
//                    ansR = l + len;
//                }
//                if (ori.containsKey(s.charAt(l))) {
//                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
//                }
//                ++l;
//            }
//        }
//        return ansL == -1 ? "" : s.substring(ansL, ansR);
//    }
//
//    public boolean check() {
//        Iterator iter = ori.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry) iter.next();
//            Character key = (Character) entry.getKey();
//            Integer val = (Integer) entry.getValue();
//            if (cnt.getOrDefault(key, 0) < val) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
////class Solution {
////    public String minWindow(String s, String t) {
////        int s_len = s.length();
////        int t_len = t.length();
////        if (s_len<t_len){
////            return "";
////        }
////        if (s.equals(t)){
////            return s;
////        }
////        HashMap<Character, Integer> hs = new HashMap<>();
////        HashMap<Character, Integer> ht = new HashMap<>();
////        String min=s;
////        for (int i = 0; i < t_len; i++) {
////            int value = 1;
////            if (ht.containsKey(t.charAt(i))) {
////                value = ht.get(t.charAt(i))+1;
////            }
////            ht.put(t.charAt(i), value);
////        }
////
////        int left=0;
////        int right=0;
////        for (; left < s_len && right<s_len; ) {
////            char c = s.charAt(left);
////            if (!ht.containsKey(c)) {
////                left++;
////                if (left==s_len){
////                    min="";
////                }
////                continue;
////            }
////            for (right = left; right < s_len; right++) {
////                char c_right = s.charAt(right);
////                int value = 1;
////                if (hs.containsKey(c_right)) {
////                    Integer integer = hs.get(c_right);
////                    value = integer + 1;
////                }
////                hs.put(c_right, value);
////
////                boolean check=true;
//////                Iterator<Character> iterator=ht.keySet().iterator();
//////                while (iterator.hasNext()){
//////                    check= hs.containsKey(iterator.next());
//////                    if (!check){
//////                        break;
//////                    }
//////                }
//////
////                for (Character set: ht.keySet()) {
////                    check=hs.containsKey(set);
////                    if (!check){
////                        break;
////                    }
////                }
////                while (check){
////                    if (s.substring(left,right+1).length()<min.length()){
////                        min=s.substring(left,right+1);
////                    }
////                    c=s.charAt(left);
////                    Integer integer = hs.get(c);
////                    if (integer==1){
////                        hs.remove(c);
////                    }
////                    else {
////                        hs.replace(c,integer-1);
////                    }
////
////                    left++;
////                    for (Character set: ht.keySet()) {
////                        check=hs.containsKey(set);
////                        if (!check){
////                            break;
////                        }
////                    }
////                }
////
////            }
////
////        }
////        return min;
////    }
////}