class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return minPath(grid,dp,0,0);
        // return dp[0][0];
    }
    public int minPath(int[][] grid,int[][] dp,int i,int j){
        if(i==grid.length-1 && j==grid[0].length-1) return grid[i][j];
        if(i>=grid.length || j>=grid[0].length) return Integer.MAX_VALUE;
        if(dp[i][j]>-1) return dp[i][j];
        int down = minPath(grid,dp,i+1,j);
        int right = minPath(grid,dp,i,j+1);
        return dp[i][j] = Math.min(down,right)+grid[i][j];

    }
}