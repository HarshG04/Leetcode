class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int pre = 1,suff=1;
        for(int i=0;i<nums.length;i++){
            pre *= nums[i];
            max = Math.max(pre,max);
            if(nums[i]==0) pre=1;
        }
        for(int i=nums.length-1;i>=0;i--){
            suff *= nums[i];
            max = Math.max(suff,max);
            if(nums[i]==0) suff=1;
        }
        return max;
    }
}