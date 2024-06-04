package 蓝桥杯;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'A']++;
        }
        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == temp[temp.length - 1]) {
                char out = (char) ('A' + i);
                System.out.print(out);
            }
        }
    }
}












