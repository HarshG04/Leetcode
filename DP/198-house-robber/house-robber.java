class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int prev = nums[0];
        int max = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            int tmp = Math.max(nums[i]+prev,max);
            prev = max;
            max = tmp;
        }
        return max;
    }
}