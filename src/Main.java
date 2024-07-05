class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr = new int[26];
        for (byte b : s.getBytes()) {
            arr[b - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            int k = i - 1;
            while (true) {
                for (int j = Math.min(repeatLimit, arr[i]); j > 0; j--) {
                    arr[i]--;
                    builder.append((char) (i + 'a'));
                }
                if (arr[i] == 0) {
                    break;
                }
                while (k >= 0 && arr[k] == 0) {
                    k--;
                }
                if (k < 0) {
                    break;
                }
                builder.append((char) (k + 'a'));
                arr[k]--;
            }
            if (arr[i] == 0) {
                i = k + 1;
            }
        }
        return builder.toString();
    }
}