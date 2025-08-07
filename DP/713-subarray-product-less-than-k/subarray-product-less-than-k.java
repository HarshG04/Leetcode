class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int si=0,ei=0;
        int pro=1;
        while(ei<nums.length){
            pro *= nums[ei];
            while(si<=ei && pro>=k) pro = pro/nums[si++];
            ans += (ei-si+1);
            ei++;
        }
        return ans;
    }
}