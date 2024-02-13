class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, result, new ArrayList<Integer>());
        return result;
        
    }
    
    public void backtrack(int[] cands, int idx, int target, List<List<Integer>> result, List<Integer> inter){
        if(target == 0){
            result.add(new ArrayList<Integer>(inter));
            return;
        }
        
        for(int i=idx; i<cands.length; i++){
            if(i>idx && cands[i] == cands[i-1]) continue;
            if(cands[i] > target) continue;
            inter.add(cands[i]);
            backtrack(cands, i+1, target-cands[i], result, inter);
            inter.remove(inter.size()-1);
        }
    }
}