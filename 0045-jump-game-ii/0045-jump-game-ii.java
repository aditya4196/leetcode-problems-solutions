class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] steps = new int[n];
        Arrays.fill(steps, n);
        
        steps[0] = 0;
        
        for(int i=0; i<n; i++){
            for(int j = i+1; j<=Math.min(i + nums[i], n-1); j++){
                steps[j] = Math.min(steps[j],steps[i] + 1);

            }
        }
        
        return steps[n-1];
        
    }
}