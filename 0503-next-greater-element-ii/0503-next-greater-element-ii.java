class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        
        for(int j=0; j<n; j++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[j]){
                result[stack.pop()] = nums[j];
            }
        }
        return result;
        
        
        
        
    }
}

/*

nums = [ 1, 2, 1]
       [ 2,-1,-1]
            
       stack = [1,2]




*/