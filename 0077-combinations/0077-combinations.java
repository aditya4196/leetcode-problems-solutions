class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        backtrack(n, 1, k, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void backtrack(int n, int curr, int k, List<Integer> inter, List<List<Integer>> result){
        if(inter.size() == k){
            result.add(new ArrayList<Integer>(inter));
            return;
        }
        
        for(int i=curr; i<=n; i++){
            inter.add(i);
            backtrack(n, i+1, k, inter, result);
            inter.remove(inter.size()-1);
        }
    }
}