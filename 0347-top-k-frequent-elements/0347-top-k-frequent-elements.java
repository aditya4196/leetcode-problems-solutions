class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> map.get(a) - map.get(b));
        
        for(int num : nums) map.put(num, map.getOrDefault(num,0)+1);
        
        for(int val : map.keySet()){
            pq.offer(val);
            if(pq.size() > k) pq.poll();
        }
        
        int[] result = new int[pq.size()];
        int i=0;
        while(pq.size() > 0) result[i++] = pq.poll();
        
        return result;
        



        
        
    }
}

