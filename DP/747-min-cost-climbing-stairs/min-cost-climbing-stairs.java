class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        minCostTD(cost,0,dp);
        return Math.min(dp[0],dp[1]);
    }
    public int minCostTD(int[] cost,int i,int[] dp){
        if(i>=cost.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int oneStep =  minCostTD(cost,i+1,dp);
        int twoStep =  minCostTD(cost,i+2,dp);
        return dp[i] = Math.min(oneStep,twoStep)+cost[i];
    }
}