class Solution {
    public int[] findBuildings(int[] heights) {
        
        Stack<Integer> stack = new Stack();

        for(int i=0; i<heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] <= heights[i]){
                stack.pop();
            }
            stack.push(i);
        }
        
        int[] result = new int[stack.size()];
        for(int i=0; i<result.length; i++){
            result[i] = stack.get(i);
        }
        
        return result;
    }
}

/*
 0 1 2 3
[4,2,3,1]

stack = [4,3,1]

*/