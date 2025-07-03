class Solution {
    public int lengthOfLIS(int[] nums) {
        return lis2(nums);
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
    public int lis2(int[] arr){
        if(arr.length==1) return 1;
        ArrayList<Integer> l = new ArrayList<>();
        int n = arr.length;
        l.add(arr[0]);
        for(int i=1;i<n;i++){
            if(arr[i]>l.get(l.size()-1)) l.add(arr[i]);
            else{
                int idx = set(l,arr[i]);
                l.set(idx,arr[i]);
            }
        }
        return l.size();
    }
    public int set(ArrayList<Integer> ll,int val){
        int l = 0, r = ll.size()-1;
        while(l<r){
            int mid = (l+r)/2;
            if(ll.get(mid)==val) return mid;
            else if(ll.get(mid)<val) l = mid+1;
            else r = mid;
        }
        return l;
    }
}