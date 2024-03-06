class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length()) return "";
        if(t.equals(s)) return t;
        
        Map<Character, Integer> countMap = new HashMap();
        for(char c : t.toCharArray()) countMap.put(c, countMap.getOrDefault(c,0)+1);
        int totalCount = countMap.size();
        int start = 0, end = 0, fstart = 0, fend = 0, minLength = Integer.MAX_VALUE;
        
        while(end < s.length()){
            char c = s.charAt(end++);
            if(countMap.containsKey(c)){
                countMap.put(c, countMap.get(c) - 1);
                if(countMap.get(c) == 0) totalCount--;
            }
            
            if(totalCount > 0) continue;
            
            while(totalCount == 0){
                char d = s.charAt(start++);
                if(countMap.containsKey(d)){
                    countMap.put(d, countMap.get(d) + 1);
                    if(countMap.get(d) == 1) totalCount++;
                } 
            }
            
            if(minLength > (end-start)){
                minLength = end-start;
                fstart = start;
                fend = end;
            }
        }
        
        return (minLength == Integer.MAX_VALUE)?"":s.substring(fstart-1, fend);
        
        
    }
}

/*
0123456789
ADOBECODEBANC
     e
 s
c
d

minlen = 

A - 1
B - 0
C - 0
count = 1





*/