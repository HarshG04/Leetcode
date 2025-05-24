class Solution {
    public int minFallingPathSum(int[][] matrix) {
     int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] a:dp){
            Arrays.fill(a,-100);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            min = Math.min(min,pathSum(matrix,dp,0,i));
        }
        return min;
    }
    public int pathSum(int[][] grid,int[][] dp,int i,int j){
        if(i==grid.length-1) return grid[i][j];
        if(dp[i][j]!=-100) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k=0;k<grid[0].length;k++){
            if(k!=j) ans = Math.min(ans,pathSum(grid, dp, i+1, k));
        }
        return dp[i][j] = ans+grid[i][j];
    }
}