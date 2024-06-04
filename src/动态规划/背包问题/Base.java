package 动态规划.背包问题;

public class Base {
    public static void main(String[] args) {
        int[] weight = new int[]{2, 3, 4, 5};
        int[] value = new int[]{3, 4, 5, 8};
        //背包容量为8,有4件商品
        int[][] dp = new int[4 + 1][8 + 1];
        //dp[i][j]表示背包容量为j时，现在有i件商品可以偷，所能偷到的最大价值
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 8; j++) {
                if(j-weight[i-1]>=0){
                    dp[i][j]=Math.max(dp[i-1][j-weight[i-1]]+value[i-1],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[4][8]);
    }

}
