class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ll = new ArrayList<>();
        for(int r=0;r<numRows;r++){
            for(int c=0;c<=r;c++){
                if(c==0 || c==r){
                    if(c==0) ll.add(new ArrayList<>());
                    ll.get(r).add(1);
                }
                else{
                    int x = ll.get(r-1).get(c-1)+ll.get(r-1).get(c);
                    ll.get(r).add(x);
                }
            }
        }
        return ll;
    }
}