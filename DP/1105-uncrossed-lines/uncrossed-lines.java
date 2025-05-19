class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return lcsBU(nums1,nums2);
    }

     public static int lcsBU(int[] t1,int[] t2){
        int[][] dp = new int[t1.length+1][t2.length+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(t1[i-1]==t2[j-1]){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    int a = dp[i-1][j];
                    int b = dp[i][j-1];
                    dp[i][j] = Math.max(a,b);
                }
            }
        }
        return dp[t1.length][t2.length];
    }
}