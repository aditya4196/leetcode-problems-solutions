class Solution {
    public String reorganizeString(String s) {
        
        Map<Character, Integer> map = new HashMap();
        PriorityQueue<Character> pq = new PriorityQueue<Character>((a,b) -> (map.get(b) - map.get(a)));
        
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        for(char c : map.keySet()){
            pq.offer(c);
        }
        
        if(pq.size() == 0) return "";
        
        StringBuilder result = new StringBuilder();
        char first = pq.poll();
        result.append(first);
        
        while(pq.size() > 0){
            char second = pq.poll();
            
            result.append(second);
            
            map.put(first, map.get(first)-1);
            if(map.get(first) > 0) pq.offer(first);
            first = second;
        }
        
        
        return (result.length() != s.length())?"":result.toString();
        
        
        
    }
}

/*

aabbabccd

aba
a - 2
b - 2
c - 2
d - 1


*/