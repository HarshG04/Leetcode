class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
       int si=0;
        int p=1;
        int count = 0;
        for(int ei=0;ei<arr.length;ei++){
            p *= arr[ei];   // grow
            while(si<=ei && p>=k){
                p /= arr[si];
                si++;
            }
            count += (ei-si)+1;

        }

        return count;
    }
}