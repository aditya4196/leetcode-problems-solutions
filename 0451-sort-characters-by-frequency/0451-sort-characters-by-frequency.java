class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> countMap = new HashMap();
        
        for(char c : s.toCharArray()){
            countMap.put(c,countMap.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<Character>((a,b)->(countMap.get(b)-countMap.get(a)));
        
        for(char c : countMap.keySet()){
            pq.offer(c);
        }
        
        StringBuilder result = new StringBuilder();
        
        while(pq.size() > 0){
            char c = pq.poll();
            while(countMap.get(c) > 0){
                result.append(c);
                countMap.put(c, countMap.get(c)-1);
            }
        }
        
        return result.toString();
        
        
    }
}