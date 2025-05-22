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
        int n = grid.length, m = grid[0].length;
        for (int i = 1; i <m; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for (int i = 1; i<n; i++) {
            grid[i][0] += grid[i-1][0];
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[n-1][m-1];
    }
}