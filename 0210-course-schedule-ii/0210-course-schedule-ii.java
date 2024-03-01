class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] adjlist = new ArrayList[numCourses];
        
        for(int i=0; i<numCourses; i++){
            adjlist[i] = new ArrayList<Integer>();
        }
        int[] indegree = new int[numCourses];

        for(int[] preq : prerequisites){
            adjlist[preq[1]].add(preq[0]);
            indegree[preq[0]]++;
        }
        
        Deque<Integer> queue = new LinkedList();
        
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        
        List<Integer> result = new ArrayList();
        
        while(queue.size()>0){
            int curr = queue.poll();
            result.add(curr);
            
            for(int next : adjlist[curr]){
                if(--indegree[next] == 0) queue.offer(next);
            }
        }
        
        if(result.size() != numCourses) return new int[0];
        else return result.stream().mapToInt(Integer::intValue).toArray();
        
        
        
        
        
    }
}