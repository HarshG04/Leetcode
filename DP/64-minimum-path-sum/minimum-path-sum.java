class Solution {
    public int minPathSum(int[][] grid) {
        // int[][] dp = new int[grid.length][grid[0].length];
        // for(int[] a:dp){
        //     Arrays.fill(a,-1);
        // }
        // return minPathTD(grid,dp,0,0);
        return minPathBU(grid);
    }
    public int minPathTD(int[][] grid,int[][] dp,int i,int j){
        if(i==grid.length-1 && j==grid[0].length-1) return grid[i][j];
        if(i>=grid.length || j>=grid[0].length) return Integer.MAX_VALUE;
        if(dp[i][j]>-1) return dp[i][j];
        int down = minPathTD(grid,dp,i+1,j);
        int right = minPathTD(grid,dp,i,j+1);
        return dp[i][j] = Math.min(down,right)+grid[i][j];
    }
    public int minPathBU(int[][] grid){
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for(int[] a:dp) Arrays.fill(a,Integer.MAX_VALUE);
        dp[1][1] = grid[0][0];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(i==1 && j==1) continue;
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];   
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}