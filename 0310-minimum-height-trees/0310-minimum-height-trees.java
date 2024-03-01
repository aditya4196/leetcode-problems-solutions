class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<Integer>[] adjlist = new ArrayList[n];
        for(int i=0; i<n; i++) adjlist[i] = new ArrayList<Integer>();
        
        
        int[] indegree = new int[n];
        
        for(int[] edge : edges){
            adjlist[edge[0]].add(edge[1]);
            adjlist[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        
        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new LinkedList();
        for(int i=0; i<n; i++){
            if(indegree[i] == 1) queue.offer(i);
        }
        
        int count = n;
        

        while(queue.size() > 0){
            int size = queue.size();
            
            if(count < 3 && (queue.size() == 1 || queue.size() == 2)){
                return new ArrayList<Integer>(queue);
            }
            
            
            for(int i=1; i<=size; i++){
                int curr = queue.poll();
                visited[curr] = true;
                count--;
                
                for(int next : adjlist[curr]){
                    if(!visited[next] && --indegree[next] == 1) queue.offer(next);
                }
            }
        }
        

        return Arrays.asList(0);
        
        
    }
}