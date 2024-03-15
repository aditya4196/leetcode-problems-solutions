class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, ArrayList<Pair<String, Integer>>> userMap = new HashMap();
        int n = username.length;
        
        for(int i=0; i<n; i++){
            userMap.computeIfAbsent(username[i], k -> new ArrayList<Pair<String, Integer>>()).add(new Pair<>(website[i], timestamp[i]));
        }
        
        HashMap<String, Integer> tripletMap = new HashMap();
        
        for(ArrayList<Pair<String,Integer>> list : userMap.values()){
            
            Collections.sort(list, (a,b) -> (a.getValue() - b.getValue()));
            Set<String> patterndups = new HashSet();
            int m = list.size();
            
            for(int i=0; i<m-2; i++){
                for(int j=i+1; j<m-1; j++){
                    for(int k = j+1; k<m; k++){    
                        String pattern = list.get(i).getKey() + "-" + list.get(j).getKey() + "-" + list.get(k).getKey();
                        if(patterndups.contains(pattern)) continue;
                        tripletMap.put(pattern, tripletMap.getOrDefault(pattern,0)+1);
                        patterndups.add(pattern);
                    }
                    
                }
            }
            
        }
        
        String largestPattern = "";
        int maxCount = 0;
        
        
        for(String pattern : tripletMap.keySet()){
            System.out.println(pattern + " : " + tripletMap.get(pattern));
            if(maxCount < tripletMap.get(pattern)){
                maxCount = tripletMap.get(pattern);
                largestPattern = pattern;
            }
            else if(maxCount == tripletMap.get(pattern)){
                if(largestPattern.compareTo(pattern) > 0){
                    largestPattern = pattern;
                }
            }
        }
        
        return Arrays.asList(largestPattern.split("-"));

        
        
        
        
        
        
    }
}

/*

["home","about","career","home","cart","maps","home","home","about","career"]
   1.     1.      1.       1,2.   2.     2.    1,2.                
        
h - ()

user -> List(website,timestamp)
sort list based on timestamps


map(string, integer)





*/