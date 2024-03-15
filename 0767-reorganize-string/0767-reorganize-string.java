class Solution {
    public String reorganizeString(String s) {
        
        HashMap<Character, Integer> countMap = new HashMap();
        for(char c : s.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<Character>((a,b) -> (countMap.get(b) - countMap.get(a)));
        
        for(char c : countMap.keySet()){
            pq.offer(c);
        }
        
        StringBuilder result = new StringBuilder();
        while(pq.size() > 0){
            char first = pq.poll();
            
            if(result.length() == 0 || (first != result.charAt(result.length()-1))){
                result.append(first);
                countMap.put(first, countMap.get(first)-1);
                if(countMap.get(first) > 0) pq.offer(first);
            }
            else{
                if(pq.size() == 0) return "";

                char second = pq.poll();
                result.append(second);
                countMap.put(second, countMap.get(second)-1);
                if(countMap.get(second) > 0) pq.offer(second);
                pq.offer(first);
            }
        }
        
        return result.toString();
        
        
    }
}

/*


a - 2
b - 2
c - 1

pq = [a,b,c]
polled = a

result = a

    



*/