class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // int[][] dp = new int[text1.length()][text2.length()];
        // for(int[] ar:dp){
        //     Arrays.fill(ar,-1);
        // }
        // return lcsTD(text1,text2,0,0,dp);

        return lcsBU(text1,text2);
    }

    public static int lcsBU(String s1,String s2){
        int[][] dp = new int[s2.length()+1][s1.length()+1];

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s1.charAt(j-1)==s2.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
        
        
        
        
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