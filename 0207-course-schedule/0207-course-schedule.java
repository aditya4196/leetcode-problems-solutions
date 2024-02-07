class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] adjlist = new ArrayList[numCourses];
        var indegree = new int[numCourses];
        Deque<Integer> queue = new ArrayDeque<Integer>();
        
        for(int i=0; i<numCourses; i++){
            adjlist[i] = new ArrayList<Integer>();
        }
        
        for(var preq : prerequisites){
            adjlist[preq[1]].add(preq[0]);
            indegree[preq[0]]++;
        }
        

        for(var i=0; i<numCourses; i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        
        while(queue.size() > 0){
            var currcourse = queue.poll();
            numCourses--;
            for(var nextcourse : adjlist[currcourse]){
                if(--indegree[nextcourse] == 0){
                    queue.offer(nextcourse);
                }
            }
        }
        
        return numCourses == 0;
        
        
        
        
        
        
    }
}