class Solution {
    public int[] findBuildings(int[] heights) {
        
        Deque<Integer> stack = new LinkedList();
        
        for(int i=0; i<heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] <= heights[i]){
                stack.pop();
            }
            stack.push(i);
        }
        
        int[] result = new int[stack.size()];
        
        for(int i=result.length-1; i>=0; i--){
            result[i] = stack.pop();
        }
        return result;
        
    }
}

/*


[1,3,2,4]

stack = [4]


*/