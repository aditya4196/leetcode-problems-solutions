class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> nextGreaterMap = new HashMap();
        for(int val : nums1) nextGreaterMap.put(val, -1);
        
        Stack<Integer> stack = new Stack();
        
        for(int num : nums2){
            while(!stack.isEmpty() && stack.peek() < num){
                if(nextGreaterMap.containsKey(stack.peek())){
                    nextGreaterMap.put(stack.peek(), num);
                }
                stack.pop();
            }
            stack.push(num);
        }
        
        for(int i=0; i<nums1.length; i++){
            nums1[i] = nextGreaterMap.get(nums1[i]);
        }
        return nums1;
        
    }
}

/*

4 - -1
1 - 3
2 - -1
 

stack = [4,2]

[1,3,4,2]






*/