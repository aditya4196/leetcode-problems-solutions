class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        backtrack(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void backtrack(int[] cands, int idx, int target, List<Integer> inter, List<List<Integer>> result){
        
        if(target == 0){
            result.add(new ArrayList<Integer>(inter));
            return;
        }
        if(target < 0) return;
        
        for(int i=idx; i<cands.length; i++){
            if(cands[i] > target) continue;
            inter.add(cands[i]);
            backtrack(cands, i, target-cands[i], inter, result);
            inter.remove(inter.size()-1);
        }
    }
}