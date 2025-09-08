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
            ArrayList<Integer> ans = new ArrayList<>();
            int[] in = indegree();
            for(int i=0;i<in.length;i++){
                if(in[i]==0) pq.add(i);
            }
            
            while(!pq.isEmpty()){
                //remove
                int rv = pq.poll();

                ans.add(rv);

                // reduce indegree and add nbrs
                for(int nbr : map.get(rv)) {
                    in[nbr]--;
                    if(in[nbr]==0) pq.add(nbr);
                }
            }

            if (ans.size() == map.size()) {
                int[] result = new int[ans.size()];
                for (int i = 0; i < ans.size(); i++) {
                    result[i] = ans.get(i); // unboxing Integer to int
                }
            return result;
            } else {
                return new int[0];
            }
            
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