class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int[] dp = new int[cost.length];
        // Arrays.fill(dp,-1);
        // minCostTD(cost,0,dp);
        // return Math.min(dp[0],dp[1]);
        return minCostBU(cost);
    }
    public int minCostTD(int[] cost,int i,int[] dp){
        if(i>=cost.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int oneStep =  minCostTD(cost,i+1,dp);
        int twoStep =  minCostTD(cost,i+2,dp);
        return dp[i] = Math.min(oneStep,twoStep)+cost[i];
    }
    public int minCostBU(int[] cost){
        int n = cost.length-1;
        int[] dp = new int[cost.length];
        dp[n] = cost[n];
        dp[n-1] = cost[n-1];
        for(int i=n-2;i>=0;i--){
            dp[i] = Math.min(dp[i+1],dp[i+2])+cost[i];
        }
        return Math.min(dp[0],dp[1]);

    }
}