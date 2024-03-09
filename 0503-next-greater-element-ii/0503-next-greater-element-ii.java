class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack();
        
        for(int i=0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        
        for(int j=0; j<nums.length; j++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[j]){
                result[stack.pop()] = nums[j];
            }
            stack.push(j);   
        }
        
        return result;
        
        
        
    }
    
    
}

/*


[1,2,1]

[2,-1,-1]

[100,1,11,1,120,111,123,1,-1,-100]
                       i
[120,11,120,120,123,123,-1,-1,-1,-1]

stack = [123,1]

*/