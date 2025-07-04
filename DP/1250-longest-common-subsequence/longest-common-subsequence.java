class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        return lcsTD(text1,text2,0,0,dp);
    }

    public static int lcsTD(String s1,String s2,int i,int j,int[][] dp){
        if(i>=s1.length() || j>=s2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int count = 0;
        if(s1.charAt(i)==s2.charAt(j)){
            count += 1 + lcsTD(s1,s2,i+1,j+1,dp);
        }else{
            int a = lcsTD(s1,s2,i,j+1,dp);
            int b = lcsTD(s1,s2,i+1,j,dp);
            count += Math.max(a,b);
        }
        return dp[i][j]=count;
    }


    public static int lcs(String s1,String s2,int i,int j){
        if(i>=s1.length() || j>=s2.length()) return 0;
        int count = 0;
        if(s1.charAt(i)==s2.charAt(j)){
            count += 1 + lcs(s1,s2,i+1,j+1);
        }else{
            int a = lcs(s1,s2,i,j+1);
            int b = lcs(s1,s2,i+1,j);
            count += Math.max(a,b);
        }
        return count;
    }
}