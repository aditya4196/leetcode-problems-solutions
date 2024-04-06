class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0, n = heights.length;
        
        for(int i=0; i<=n; i++){
            int currHeight = ((i == n)?0:heights[i]);
            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){
                int minHeight = heights[stack.pop()];
                int area = (i - (stack.isEmpty()?0:(stack.peek()+1)))*minHeight;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        
        return maxArea;
        
        
    }
}