class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList();
        backtrack(1, k, n, new ArrayList<Integer>(), result);
        return result;
        
    }
    
    public void backtrack(int curr, int k, int n, List<Integer> inter, List<List<Integer>> result){
        if(n == 0 && k == 0){
            result.add(new ArrayList<Integer>(inter));
            return;
        }
        
        if(k < 0) return;
        
        for(int i=curr; i<=9; i++){
            if(i > n) continue;
            inter.add(i);
            backtrack(i+1, k-1, n-i, inter, result);
            inter.remove(inter.size()-1);
        }
    }
}