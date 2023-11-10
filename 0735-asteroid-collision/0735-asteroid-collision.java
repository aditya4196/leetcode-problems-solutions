class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Deque<Integer> stack = new LinkedList();
        int i=0;
        while(i < asteroids.length){
            if(asteroids[i] < 0 && !stack.isEmpty() && stack.peek() > 0){
                if(stack.peek() < (-1*asteroids[i])){
                    stack.pop();
                }
                else if(stack.peek() == (-1*asteroids[i])){
                    stack.pop();
                    i++;
                }
                else{
                    i++;
                }
            }
            else{
                stack.push(asteroids[i]);
                i++;
            }
        }
        
        int[] result = new int[stack.size()];
        int j=stack.size()-1;
        for(int val : stack){
         result[j--] = val;   
        }
        
        return result;
        
        
        
    }
}

/*

[5, 10, -5]

collision - 
if curr is neg 
    while stack.peek() is positive abs(stack.peek()) < abs()



*/