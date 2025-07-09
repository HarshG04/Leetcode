class Solution {
    public int change(int amount, int[] coins) {
        // return coin(coins,amount,0);

        int[][] dp = new int[amount+1][coins.length];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return coinTD(coins,amount,0,dp);
    }
    public int coinTD(int[] arr,int amm,int i,int[][] dp){
        if(amm==0) return 1;
        if(amm<0 || i>=arr.length) return 0;
        if(dp[amm][i]!=-1) return dp[amm][i];
        int pick=0;
        if(amm>=arr[i]) pick = coinTD(arr,amm-arr[i],i,dp);
        int nopick = coinTD(arr,amm,i+1,dp);
        return dp[amm][i]=pick+nopick;
    }
    public int coin(int[] arr,int amm,int i){
        if(amm==0) return 1;
        if(amm<0 || i>=arr.length) return 0;
        int pick=0;
        if(amm>=arr[i]) pick = coin(arr,amm-arr[i],i);
        int nopick = coin(arr,amm,i+1);
        return pick+nopick;
    }
}