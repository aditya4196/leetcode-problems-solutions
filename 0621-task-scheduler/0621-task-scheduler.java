class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        Map<Character, Integer> map = new HashMap();
        for(char task : tasks){
            map.put(task, map.getOrDefault(task,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->(b-a));
        pq.addAll(map.values());
        int result = 0;
        
        while(pq.size() > 0){
            List<Integer> placed = new ArrayList<Integer>();
            int cycle = n+1;
            
            for(int i=1; i<=cycle; i++){
                if(pq.size() > 0){
                    placed.add(pq.poll());
                }
            }
            
            for(int freq : placed){
                if(--freq > 0){
                    pq.offer(freq);
                }
            }
            
            result += (pq.size() > 0)?cycle:placed.size();
        }
        
        return result;
        
        
        
    }
}