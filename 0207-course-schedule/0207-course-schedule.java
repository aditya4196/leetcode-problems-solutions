class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
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
        int coursesCompleted = 0;
        
        while(queue.size() > 0){
            int curr = queue.poll();
            coursesCompleted++;
            
            for(int nextCourse : adjlist[curr]){
                if(--indegree[nextCourse] == 0) queue.offer(nextCourse);
            }
        }
        
        return coursesCompleted == numCourses;
        
    }
}