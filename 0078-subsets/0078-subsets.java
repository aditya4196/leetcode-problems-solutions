class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int n = nums.length;
        
        for(int i=0; i<(1<<n); i++){
            List<Integer> inter = new ArrayList();
            int mask = 1;
            for(int j=0; j<n; j++){
                if(((mask<<j)&i) != 0){
                    inter.add(nums[j]);
                }
            }
            result.add(inter);
        }
        
        return result;
        
        
        
        
    }
}