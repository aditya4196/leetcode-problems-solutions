class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<Character>((a,b) -> map.get(b)-map.get(a));
        for(char c : map.keySet()) pq.offer(c);
        
        StringBuilder result = new StringBuilder();
        while(pq.size() > 0){
            char c = pq.poll();
            for(int i=1; i<=map.get(c); i++){
                result.append(c);
            }
        }
        
        return result.toString();
        
        
        
    }
}

/*


tree




*/