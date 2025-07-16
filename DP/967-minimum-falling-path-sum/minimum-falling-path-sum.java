class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // int ans = Integer.MAX_VALUE;
        // for(int i=0;i<matrix[0].length;i++){
        //     ans = Math.min(minfall(matrix,0,i),ans);
        // }
        // return ans;

        int[][]dp=new int[matrix.length][matrix[0].length];
        for(int[]a:dp) Arrays.fill(a,-100000);
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            ans = Math.min(minfallTD(matrix,0,i,dp),ans);
        }
        return ans;
        
    }
    public int minfallTD(int[][] arr,int i,int j,int[][]dp){
        if(j>=arr[0].length || j<0) return Integer.MAX_VALUE;
        if(i==arr.length-1) return arr[i][j];
        if(dp[i][j]>-100000) return dp[i][j];
        int lft = minfallTD(arr,i+1,j-1,dp);
        int dwn = minfallTD(arr,i+1,j,dp);
        int rgt = minfallTD(arr,i+1,j+1,dp);
        return dp[i][j]=Math.min(lft,Math.min(dwn,rgt))+arr[i][j];
    }
    public int minfall(int[][] arr,int i,int j){
        if(j>=arr[0].length || j<0) return Integer.MAX_VALUE;
        if(i==arr.length-1) return arr[i][j];
        int lft = minfall(arr,i+1,j-1);
        int dwn = minfall(arr,i+1,j);
        int rgt = minfall(arr,i+1,j+1);
        return Math.min(lft,Math.min(dwn,rgt))+arr[i][j];
    }
}