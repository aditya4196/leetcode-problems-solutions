class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        Map<Integer, Integer> map = new HashMap();
        Set<Integer> seen = new HashSet();
        
        for(int[] match : matches){
            seen.add(match[0]);
            seen.add(match[1]);
            map.put(match[1], map.getOrDefault(match[1],0)+1);
        }
        
        List<Integer> ans1 = new ArrayList<Integer>();
        List<Integer> ans2 = new ArrayList<Integer>();
        
        for(int player : seen){
            if(!map.containsKey(player)) ans1.add(player);
            else if(map.get(player) == 1) ans2.add(player);
        }

        Collections.sort(ans1);
        Collections.sort(ans2);
        
        List<List<Integer>> result = new ArrayList();
        result.add(ans1);
        result.add(ans2);
        
        return result;
        
    }
}