class Solution {
    public int trap(int[] height) {
        
        Deque<Integer> stack = new LinkedList();
        int watercollected = 0;
        
        for(int i=0; i<height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int popped = stack.pop();
                if(stack.isEmpty()) break;
                int distance = i - stack.peek() - 1;
                int minheight = Math.min(height[i], height[stack.peek()]) - height[popped];
                watercollected += (distance*minheight);
            }
            stack.push(i);
        }
        
        return watercollected;     
        
    }
}


/*

 0 1 2 3 4 5 6 7 8 9
[0,1,0,2,1,0,1,3,2,1,2,1]

curr = 3
stack = [1]
popped = 2

dist = 1
minheight = 0
water collected = 0



*/