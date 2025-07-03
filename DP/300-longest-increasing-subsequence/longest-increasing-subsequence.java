class Solution {
    public int lengthOfLIS(int[] nums) {
        return lis(nums);
    }
    public int lis(int[] arr){
        if(arr.length==1) return 1;
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=1;i<n;i++){
            int j=i-1;
            while(j>=0){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
                j--;
            }
        }
        return max;
    }
}