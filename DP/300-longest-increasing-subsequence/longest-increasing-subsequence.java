class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==1) return 1;
        return lis(nums);
    }
    public int lis(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]) dp[i] = Math.max(dp[i],dp[j]+1);
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
}