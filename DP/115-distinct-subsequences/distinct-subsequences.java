class Solution {
    public int numDistinct(String s, String t) {
        // return subseq(s,t,0,0);
        int[][] dp = new int[s.length()][t.length()];
        for(int[]a:dp) Arrays.fill(a,-1);
        return subseqTD(s,t,0,0,dp);
    }
    // i -> s -> coins
    // j -> t -> amount
    public int subseqTD(String s,String t,int i,int j,int[][] dp){
        if(j>=t.length()) return 1;
        if(i>=s.length()) return 0;
        if(dp[i][j]>-1) return dp[i][j]; 
        int inc=0,exc=0;
        if(s.charAt(i)==t.charAt(j)){
            inc = subseqTD(s,t,i+1,j+1,dp);
        }
        exc = subseqTD(s,t,i+1,j,dp);
        return dp[i][j]=inc+exc;
    }

    public int subseq(String s,String t,int i,int j){
        if(j>=t.length()) return 1;
        if(i>=s.length()) return 0;
        int inc=0,exc=0;
        if(s.charAt(i)==t.charAt(j)){
            inc = subseq(s,t,i+1,j+1);
        }
        exc = subseq(s,t,i+1,j);
        return inc+exc;
    }
}