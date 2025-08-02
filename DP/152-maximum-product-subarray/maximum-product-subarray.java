class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            ans = Math.max(ans,curr);
            for(int j=i+1;j<nums.length;j++){
                curr *= nums[j];
                ans = Math.max(ans,curr);
            }
        }
        return ans;
    }
}