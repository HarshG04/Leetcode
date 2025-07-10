class Solution {
    public int minPathSum(int[][] grid) {
        // return minpath(grid,0,0,0);
        return minPathBU(grid);
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
    public int minpath(int[][]grid,int i,int j,int sum){
        if(i==grid.length-1 && j==grid[0].length-1) return sum+grid[i][j];
        if(j>=grid[0].length || i>=grid.length) return Integer.MAX_VALUE;
        sum+=grid[i][j];
        int dwn = minpath(grid,i+1,j,sum);
        int rgt = minpath(grid,i,j+1,sum);
        return Math.min(dwn,rgt);
    }
}