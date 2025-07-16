class Solution {
    public int minFallingPathSum(int[][] grid) {
    int[][]dp=new int[grid.length][grid[0].length];
        for(int[]a:dp) Arrays.fill(a,-100000);
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            ans = Math.min(minfallTD(grid,0,i,dp),ans);
        }
        return ans;
        
    }
    public int minfallTD(int[][] arr,int i,int j,int[][]dp){
        if(j>=arr[0].length || j<0) return Integer.MAX_VALUE;
        if(i==arr.length-1) return arr[i][j];
        if(dp[i][j]>-100000) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k=0;k<arr[0].length;k++){
            if(k!=j) ans=Math.min(ans,minfallTD(arr,i+1,k,dp));
        }
        // int lft = minfallTD(arr,i+1,j-1,dp);
        // int dwn = minfallTD(arr,i+1,j,dp);
        // int rgt = minfallTD(arr,i+1,j+1,dp);
        return dp[i][j]=ans+arr[i][j];
    }
}