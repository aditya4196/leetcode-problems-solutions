class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        Deque<Integer> stack = new LinkedList();
        
        for(int num : nums2){
            while(!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        for(int i=0; i<nums1.length; i++){
            nums1[i] = map.getOrDefault(nums1[i],-1);
        }
        
        return nums1;
        
        
        
    }
}

/*

[1,3,4,2,5]

stack = [4,]

1 - 3
3 - 4
4 - 5
2 - 5
*/