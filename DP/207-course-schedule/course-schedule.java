class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Topological_Sort ts = new Topological_Sort(numCourses);
        for(int i=0;i<prerequisites.length;i++){
            ts.AddEdge(prerequisites[i][1],prerequisites[i][0]);
        }

        return ts.TopologicalSort();
    }

    class Topological_Sort{
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

          Topological_Sort(int v){
            for(int i=0;i<v;i++){
                map.put(i,new ArrayList<>());
            }
        }

        public void AddEdge(int v1,int v2){
            map.get(v1).add(v2);
        }

        
        public boolean TopologicalSort(){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int[] in = indegree();
            for(int i=0;i<in.length;i++){
                if(in[i]==0) pq.add(i);
            }

            int count = 0;

            while(!pq.isEmpty()){
                // remove
                count++;
                int rv = pq.poll();

                for(int i : map.get(rv)){
                    in[i]--;
                    if(in[i]==0) pq.add(i);
                }
            }

            return count == map.size();
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