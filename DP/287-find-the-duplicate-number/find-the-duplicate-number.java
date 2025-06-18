class Solution {
    public int findDuplicate(int[] arr) {
        int x = arr[0];
        int y = arr[0];
        while(true){
            x = arr[x];
            y = arr[arr[y]];
            if(x==y) break;
        }
        x = arr[0];
        while(x!=y){
            x = arr[x];
            y = arr[y];
        }
        return x;

    }
}