class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums==null || nums.length==0) return null;

        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>(); 
        kSum(nums, target, 4, 0, new ArrayList<>(), output);
        return output;
        
    }


    void kSum(int[] nums, long target, int k, int start, List<Integer> tempOutput, List<List<Integer>> output) {
        
        if(k==2) {
            int left=start;
            int right = nums.length-1;
            while(left<right) {
                long diff = target-nums[left];
                if(diff==nums[right]) {
                        List<Integer> temp = new ArrayList<>(tempOutput);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        output.add(temp);
                        left++;
                        right--;
                        while(left<right && nums[left]==nums[left-1]) left++;
                        // while(left<right && nums[right]==nums[right+1]) right--;
                } else if (diff<nums[right]) {
                    right--;
                } else {
                    left++;
                }
            } 
            return;
        }


        // nums = [1,0,-1,0,-2,2]
        // nums = [-2,-1,0,0,1,2]
        // k =4
        // index = [0, 3)
        // target =3
        for(int index=start; index<=nums.length-k;index++) {
            if(index!=start && nums[index]==nums[index-1]) continue;
            tempOutput.add(nums[index]);
            kSum(nums, target-nums[index], k-1, index+1, tempOutput, output);
            tempOutput.remove(tempOutput.size()-1);
        }


    }
}