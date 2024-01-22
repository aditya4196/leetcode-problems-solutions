class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int sum = 0, duplicate = 0, expectedSum = 0;
        
        for(int i=0; i<n; i++){
            expectedSum += (i+1);
            sum += Math.abs(nums[i]);
            if(nums[Math.abs(nums[i])-1] > 0){
                nums[Math.abs(nums[i])-1] = -1*nums[Math.abs(nums[i])-1];
            }
            else{
                duplicate = Math.abs(nums[i]);
            }
        }
        System.out.println(expectedSum + "-" + sum);
        return new int[]{duplicate, expectedSum-(sum-duplicate)};
        
        
        
    }
}