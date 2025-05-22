class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] a:dp){
            Arrays.fill(a,-200);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            min = Math.min(min,minPathTD(matrix,dp,0,i));
        }
        return min;
    }
    public int minPathTD(int[][] grid,int[][] dp,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid.length) return Integer.MAX_VALUE;
        if(i==grid.length-1) return grid[i][j];
        if(dp[i][j]!=-200) return dp[i][j];
        int lft = minPathTD(grid,dp,i+1,j-1);
        int down = minPathTD(grid,dp, i+1, j);
        int rgt = minPathTD(grid,dp,i+1, j+1);
        return dp[i][j] = Math.min(lft,Math.min(down,rgt)) + grid[i][j];
    }
}