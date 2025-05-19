class Solution {
    public int lengthOfLIS(int[] nums) {
        return LIS1(nums);
    }
    
    public int LIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
        }
        int max = dp[0];
        for(int i:dp) max = Math.max(max,i);
        return max;
    }

    public static int LIS1(int[] nums){
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int idx = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>arr[idx-1]) arr[idx++] = nums[i];
            else{
                int j = search(arr,nums[i],idx);
                arr[j] = nums[i];
            }
        }
        return idx;
    }
    public static int search(int[] arr,int val,int j){
        int i = 0;
        while(i<=j){
            int mid = (i+j)/2;
            if(arr[mid]>val) j = mid-1;
            else if(arr[mid]<val) i = mid+1;
            else return mid;
        }
//        System.out.println("Right : "+val+" " +i);
        return i;
    }
}