class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (distance(b) - distance(a)));
        
        for(int[] point : points){
            pq.offer(point);
            if(pq.size() > k) pq.poll();
        }
                                                           
        List<int[]> result = new ArrayList(pq);
        return result.toArray(new int[result.size()][]);                                                   
                                                         
    
        
        
        
    }
    
    public int distance(int[] p1){
        return (p1[0]*p1[0] + p1[1]*p1[1]);
    }
}