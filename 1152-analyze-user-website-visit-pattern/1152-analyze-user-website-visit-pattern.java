class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        
        Map<String, List<Pair<String, Integer>>> userMap = new HashMap();
        Map<String, Integer> patternMap = new HashMap();
        
        for(int i=0; i<username.length; i++){
            userMap.computeIfAbsent(username[i], k-> new ArrayList<Pair<String, Integer>>())
                .add(new Pair<String, Integer>(website[i], timestamp[i]));
        }
        
        HashSet<String> patternSet;
        
        for(List<Pair<String, Integer>> list : userMap.values()){
            Collections.sort(list, (a,b) -> (Integer.compare(a.getValue(),b.getValue())));
            int n = list.size();
            
            patternSet = new HashSet<String>();
            for(int i=0; i<=(n-3); i++){
                for(int j=i+1; j<=(n-2); j++){
                    for(int k=j+1; k<=(n-1); k++){
                        
                        String pattern = list.get(i).getKey() + "-" + list.get(j).getKey() + "-" + list.get(k).getKey();
                        if(patternSet.contains(pattern)) continue;
                        patternMap.put(pattern, patternMap.getOrDefault(pattern,0)+1);
                        patternSet.add(pattern);
                    }
                }

            }
        }
        
        int maxScorePattern = 0;
        String result = "";
        
        for(String pattern : patternMap.keySet()){
            int score = patternMap.get(pattern);
                        
            if(score > maxScorePattern){
                maxScorePattern = score;
                result = pattern;
            }
            else if(score == maxScorePattern){
                if(result.compareTo(pattern) > 0){
                    result = pattern;
                }
            }
        }
        
        return Arrays.asList(result.split("-"));
        
    }
}