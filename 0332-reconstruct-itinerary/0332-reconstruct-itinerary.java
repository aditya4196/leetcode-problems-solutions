class Solution {
    
    LinkedList<String> result = null;
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, LinkedList<String>> adjlist = new HashMap();
        
        for(List<String> path : tickets){
            String src = path.get(0), dest = path.get(1);
            adjlist.computeIfAbsent(src, k -> new LinkedList<String>()).add(dest);  
        }
        
        adjlist.forEach((key, value) -> Collections.sort(value));
        
        result = new LinkedList<String>();
        traverse(adjlist, "JFK");
        return this.result;
        
    
    }

    
    public void traverse(Map<String, LinkedList<String>> adjlist, String src){
        if(adjlist.containsKey(src)){
            
            LinkedList<String> list = adjlist.get(src);
            while(!list.isEmpty()){ 
                String next = list.pollFirst();
                traverse(adjlist, next);        
            }
        }
        result.add(0,src);
    }
}

/*


JFK - 2
ATL - 1
SFO - 0


JFK -> (ATL, SFO)
              
ATL -> (JFK, SFO)
         
SFO -> (ATL)
         i
JFK -> ATL -> JFK -> SFO -> ATL -> SFO








*/