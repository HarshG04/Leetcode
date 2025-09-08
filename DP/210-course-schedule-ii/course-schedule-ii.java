class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Topological_Sort ts = new Topological_Sort(numCourses);
            for(int i=0;i<prerequisites.length;i++){
                ts.AddEdge(prerequisites[i][1],prerequisites[i][0]);
            }

            return ts.TopologicalSort();
    }
    class Topological_Sort{
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        Topological_Sort(int v){
            for(int i=0;i<v;i++) map.put(i,new ArrayList<>());
        }
        public void AddEdge(int v1,int v2){
            map.get(v1).add(v2);
        }

        public int[] TopologicalSort(){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            
            int[] in = indegree();
            for(int i=0;i<in.length;i++){
                if(in[i]==0) pq.add(i);
            }
            
            int[] ans = new int[map.size()];
            int idx =  0;
            int count = 0;
            while(!pq.isEmpty()){
                //remove
                int rv = pq.poll();

                ans[idx++]=rv;
                count++;

                // reduce indegree and add nbrs
                for(int nbr : map.get(rv)) {
                    in[nbr]--;
                    if(in[nbr]==0) pq.add(nbr);
                }
            }

            if(count!=map.size()) return new int[0];
            return ans;
            
        }
        public int[] indegree(){
            int[] in = new int[map.size()];

            for(int key : map.keySet()){
                for(int nbr : map.get(key)) in[nbr]++;
            }

            return in;
        }

    }
}