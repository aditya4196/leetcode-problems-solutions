class Solution {
    
    Integer[] startTime;
    Integer[] endTime;
    int time;
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        startTime = new Integer[numCourses];
        endTime = new Integer[numCourses];
        time = 1;
        
        List<Integer>[] adjlist = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            adjlist[i] = new ArrayList<Integer>();
        }
        for(int[] preq : prerequisites){
            adjlist[preq[1]].add(preq[0]);
        }
        
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!visited[i] && dfs(adjlist, i, visited)) return false;
        }
        return true;
    }
    
    public boolean dfs(List<Integer>[] adjlist, int curr, boolean[] visited){
        visited[curr] = true;
        startTime[curr] = time++;
        
        for(int next : adjlist[curr]){
            if(visited[next] && endTime[next] == null) return true;
            if(!visited[next] && dfs(adjlist, next, visited)) return true;
        }
        
        endTime[curr] = time++; 
        System.out.println(curr + "-" + startTime[curr] + "-" + endTime[curr]);
        return false;
    }
    
    
    
    
    
    
    
}