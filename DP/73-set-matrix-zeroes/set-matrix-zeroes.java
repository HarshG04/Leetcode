class Solution {
    public void setZeroes(int[][] matrix) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    if(map.get(i)==null) map.put(i,new ArrayList<>());
                    map.get(i).add(j);
                }
            }
        }

        for(int r : map.keySet()){
            for(int c : map.get(r)){
                setZeros(matrix,r,c);
            }
        }
 
    }
    public void setZeros(int[][] arr,int r,int c){
        for(int i=0;i<arr[0].length;i++){
            arr[r][i] = 0;
        }
        for(int i=0;i<arr.length;i++){
            arr[i][c] = 0;
        }
        

    }
}