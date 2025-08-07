class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int pro = 1;
        int idx = 0;
        for(int i=0;i<nums.length;i++){
            pro *= nums[i];
            while(idx<=i && pro>=k) pro /= nums[idx++];
            count+=(i-idx+1);
        }
        return count;
    }
}