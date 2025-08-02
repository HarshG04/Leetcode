class Solution {
    public int[] countBits(int n) {
        int[] arr=new int[n+1];
        for(int i=0;i<=n;i++){
            arr[i]=count(i);
        }
        return arr;
    }
    public int count(int x){
        int count = 0;
        while(x>0){
            if(x%2==1) count+=1;
            x/=2; 
        }
        return count;
    }
}