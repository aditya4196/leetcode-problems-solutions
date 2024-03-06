class Solution {
    
    HashMap<Character, Set<Character>> adjlist;
    HashMap<Character, Set<Character>> revlist;
    HashMap<Character, Integer> degrees;
    
    public String alienOrder(String[] words) {
        
        
        //initialize
        initialize(words);
        
        int n = words.length;
        //build list
        
        for(int i=0; i<n-1; i++){
            String w1 = words[i], w2 = words[i+1];            
            int minLength = Math.min(w1.length(), w2.length());
            boolean allCharsMatched = true;
            
            for(int j=0; j<minLength; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    adjlist.computeIfAbsent(w1.charAt(j), k -> new HashSet<Character>()).add(w2.charAt(j));  
                    revlist.computeIfAbsent(w2.charAt(j), k -> new HashSet<Character>()).add(w1.charAt(j));
                    allCharsMatched = false;
                    break;
                }
            }
            
            if(allCharsMatched && w1.length() > w2.length()) return "";
        }
        
        //fill the outdegrees
        for(char c : adjlist.keySet()){
            degrees.put(c, adjlist.get(c).size());
        } 
    
        // for(char c : adjlist.keySet()){
        //     System.out.println(c + "-" + Arrays.asList(adjlist.get(c)));
        // } 

        
        //bfs
        Deque<Character> queue = new LinkedList();
        
        for(char c : revlist.keySet()){
            if(degrees.get(c) == 0) queue.offer(c);
        }
        
        
        
        if(queue.size() == 0) return "";
        
        StringBuilder result = new StringBuilder();
        Set<Character> visited = new HashSet();
        
        
        while(queue.size() > 0){
            
            int size = queue.size();
            for(int i=1; i<=size; i++){
                char curr = queue.poll();
                System.out.println(curr);
                result.append(curr);
                visited.add(curr);
                
                for(char next : revlist.get(curr)){
                    if(visited.contains(next)) return "";
                    
                    int degree = degrees.get(next);
                    
                    if(--degree == 0) queue.offer(next);
                    degrees.put(next, degree);
                }
            }
        }

        if(result.length() != revlist.size()) return "";
        
        return result.reverse().toString();  
    }
    
    public void initialize(String[] words){
        revlist = new HashMap();
        adjlist = new HashMap();
        degrees = new HashMap();
        
        for(int i=0; i<words.length; i++){
            for(char c : words[i].toCharArray()){
                revlist.put(c, new HashSet<Character>());
                adjlist.put(c, new HashSet<Character>());
                degrees.put(c, 0);
            }
        }
    }
    

    
    
}