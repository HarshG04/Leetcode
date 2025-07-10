class Solution {
    public int minPathSum(int[][] grid) {
        // return minpath(grid,0,0,0);
        return minpathBU(grid);
    }
    public int minpathBU(int[][] grid){
        int[][] dp=new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0) continue;
                int x=Integer.MAX_VALUE,y=x;
                if(i>0) x=dp[i-1][j];
                if(j>0) y=dp[i][j-1];
                dp[i][j]=Math.min(x,y)+grid[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
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