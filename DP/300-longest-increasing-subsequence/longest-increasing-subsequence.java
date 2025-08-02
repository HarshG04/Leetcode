class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==1) return 1;
        return lis(nums);
    }
    public int lis(int[] nums){
        int n = nums.length;
        ArrayList<Integer> ll = new ArrayList<>();
        ll.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i]>ll.get(ll.size()-1)) ll.add(nums[i]);
            else ll.set(right(ll,nums[i]),nums[i]);
            // System.out.println(ll);
        }
        return ll.size();
    }
    public static int right(ArrayList<Integer> ll,int val){
        int i=0,j=ll.size()-1;
        while(i<j){
            int mid = (i+j)/2;
            if(ll.get(mid)==val){
                // System.out.println(val+" "+mid);
                return mid;
            }
            else if(ll.get(mid)>val) j = mid;
            else i=mid+1;
        }
        // System.out.println(val+". "+i);
        return i;
    }
}