class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length];
        for(int[] a:dp) Arrays.fill(a,-1);
        // return coin(coins,amount,0);
        return coinTD(coins,amount,0,dp);
    }
    public int coin(int[] coin,int am,int i){
        if(am==0) return 1;
        if(i>=coin.length) return 0;
        int pick=0,noPick=0;
        if(am>=coin[i]) pick = coin(coin,am-coin[i],i);
        noPick = coin(coin,am,i+1);
        return pick+noPick;

    }
    public int coinTD(int[] coin,int am,int i,int[][] dp){
        if(am==0) return 1;
        if(i>=coin.length) return 0;
        if(dp[am][i]!=-1) return dp[am][i];
        int pick=0,noPick=0;
        if(am>=coin[i]) pick = coinTD(coin,am-coin[i],i,dp);
        noPick = coinTD(coin,am,i+1,dp);
        return dp[am][i]=pick+noPick;

    }
}