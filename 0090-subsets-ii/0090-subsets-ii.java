class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        Set<String> seen = new HashSet();
        
        List<List<Integer>> result = new ArrayList();
        int n = nums.length;

        for(int i=0; i<(int)Math.pow(2,n); i++){
            
            StringBuilder hashcode = new StringBuilder();
            List<Integer> inter = new ArrayList();
            
            for(int j=0; j<n; j++){
                int mask = 1<<j;
                if((mask&i) != 0){
                    inter.add(nums[j]);
                    hashcode.append(nums[j]);
                }
            }
            if(!seen.contains(hashcode.toString())){
                result.add(new ArrayList<Integer>(inter));
                seen.add(hashcode.toString());
            }
            
        }
        
        return result;
        
    
        
    }
}