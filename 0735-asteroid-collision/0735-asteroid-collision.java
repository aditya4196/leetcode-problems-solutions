class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList();
        
        int idx = 0;
        while(idx < asteroids.length){
            int curr = asteroids[idx];
            if(curr < 0 && !stack.isEmpty() && stack.peek() > 0){
                    if(stack.peek() > -1*curr){
                        idx++;
                    }
                    else if(stack.peek() < -1*curr){
                        stack.pop();
                    }
                    else{
                        idx++;
                        stack.pop();
                    }
                }
                else{
                    stack.push(curr);
                    idx++;
                }
        }
        
        int[] result = new int[stack.size()];
        
        int i=stack.size()-1;
        while(!stack.isEmpty()){
            result[i--] = stack.pop();
        }
        
        return result;
        
        
    }
}