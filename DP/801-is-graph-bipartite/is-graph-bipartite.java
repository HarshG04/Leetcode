class Solution {
    class pair{
        int v; int dis;
        pair(int v,int dis){
            this.v = v;
            this.dis = dis;
        }
    }
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer,Integer> visited = new HashMap<>();
        Queue<pair> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(visited.containsKey(i)) continue;
            q.add(new pair(i,0));
            while(!q.isEmpty()){
                // remove
                pair rv = q.poll();
                // check if exists
                if(visited.containsKey(rv.v)){
                    if(visited.get(rv.v)!=rv.dis) return false;
                }
                // add visited
                visited.put(rv.v,rv.dis);
                // self
                // add nbrs
                for(int nbr:graph[rv.v]){
                    if(!visited.containsKey(nbr)) q.add(new pair(nbr,rv.dis+1)); 
                }
            }
        }
        return true;
    }
}