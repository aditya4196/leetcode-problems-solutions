class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new LinkedList();
        
        for(int i=0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        
        int j=0;
        while(j<nums.length & !stack.isEmpty()){
            if(nums[j] > nums[stack.peek()]) result[stack.pop()] = nums[j];
            else j++;
        }
        
        return result;
        
        
    }
}

/*

[100,1,11,1,120,111,123,1,-1,-100]
  i
  j
stack = [120]

1 - 11
1 - 120


*/