class Solution {
    public int minDistance(String word1, String word2) {
        int[][]dp = new int[word1.length()][word2.length()];
        for(int[]a:dp)Arrays.fill(a,-1);
        return mindis(word1,word2,0,0,dp);
    }
    public int mindis(String s1,String s2,int i,int j,int[][]dp){
        if(s1.length()==i) return s2.length()-j;
        if(s2.length()==j) return s1.length()-i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=mindis(s1,s2,i+1,j+1,dp);
        }else{
            int ins = mindis(s1,s2,i,j+1,dp);
            int del = mindis(s1,s2,i+1,j,dp);
            int rep = mindis(s1,s2,i+1,j+1,dp);
            return dp[i][j]=Math.min(ins,Math.min(del,rep))+1;
        }
    }

}