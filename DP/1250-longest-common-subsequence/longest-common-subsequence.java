class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // int[][]dp=new int[text1.length()][text2.length()];
        // for(int[]a:dp) Arrays.fill(a,-1);
        // return lcs(text1,text2,0,0,dp);
        return lcsBU(text1,text2);
    }
    public int lcsBU(String s1,String s2){
        int[][]dp = new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public int lcs(String s1,String s2,int i,int j,int[][]dp){
        if(j==s2.length() || i==s1.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)) ans = lcs(s1,s2,i+1,j+1,dp)+1;
        else ans = Math.max(lcs(s1,s2,i+1,j,dp),lcs(s1,s2,i,j+1,dp));
        return dp[i][j]=ans;
    }
}