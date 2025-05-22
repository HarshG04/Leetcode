class Solution {
    public int minDistance(String word1, String word2) {
        return edistBU(word1,word2);
    }
    public static int edistBU(String s,String t){
        if(s.isEmpty() && t.isEmpty()) return 0;
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(s.charAt(i-1)!=t.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }else {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}