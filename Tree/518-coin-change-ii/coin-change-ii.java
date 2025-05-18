class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        for (int am = 1; am < dp.length; am++) {// amount
            for (int i = 1; i < dp[0].length; i++) {// coin
                int inc = 0, exc = 0;
                if (coins[i - 1] <= am) {
                    inc = dp[am - coins[i - 1]][i];
                }
                exc = dp[am][i - 1];
                dp[am][i] = inc + exc;
            }

        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
    
}