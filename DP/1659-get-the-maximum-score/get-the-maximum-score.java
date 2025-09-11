class Solution {
    public int maxSum(int[] arr1, int[] arr2) {
        long max = 0;
        long sum1 = 0;
        long sum2 = 0;
        int i=0, j=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                sum1 += arr1[i];
                i++;
                
            }else if(arr1[i]>arr2[j]){
                sum2 += arr2[j];
                j++;
            }else{
                max += Math.max(sum1,sum2)+arr1[i];
                sum1=0;sum2=0;
                i++;j++;
            }
        }
        
        while(i<arr1.length){
            sum1+=arr1[i];
            i++;
        }
        while(j<arr2.length){
            sum2+=arr2[j];
            j++;
        }
        max += Math.max(sum1,sum2);
       int result = (int)(max%1000000007);
       return result;
    }
    
}