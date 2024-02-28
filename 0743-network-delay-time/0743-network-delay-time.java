class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        
        //adj list
        List<Pair<Integer, Integer>>[] adjlist = new ArrayList[n+1];
        
        for(int i=0; i<=n; i++){
            adjlist[i] = new ArrayList<Pair<Integer, Integer>>();
        }
        
        for(int[] time : times){
            adjlist[time[0]].add(new Pair(time[1],time[2]));
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Deque<Integer> queue = new ArrayDeque();
        queue.add(k);
        dist[k] = 0;
        
        while(queue.size() > 0){
            int curr = queue.poll();
            
            for(Pair<Integer, Integer> pair : adjlist[curr]){
                int next = pair.getKey();
                int time = pair.getValue();
                
                if(dist[next] > (dist[curr] + time)){
                    dist[next] = dist[curr] + time;
                    queue.offer(next);
                }
            }
        }
        
        int minTime = -1;
        
        for(int i=1; i<=n; i++){
            System.out.println(dist[i]);
            if(dist[i] != Integer.MAX_VALUE){
                minTime = Math.max(minTime, dist[i]);
            }
            else return -1;
        }
        
        return minTime; 
        
    }
}