class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap();
        for(String word : words) map.put(word, map.getOrDefault(word,0)+1);
        
        PriorityQueue<String> pq = new PriorityQueue<String>((a,b) -> ((map.get(a) == map.get(b))?(b.compareTo(a)):(map.get(a) - map.get(b))));
        
        for(String word : map.keySet()){
            pq.offer(word);
            if(pq.size() > k) pq.poll();
        }
        
       List<String> result = new LinkedList();
       while(pq.size() > 0){
           result.add(0, pq.poll());
       }
        
        return result;
       
        
    }
    

}