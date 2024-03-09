class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        int idx=0, n = asteroids.length;
        Stack<Integer> stack = new Stack<Integer>();
        
        while(idx < n){
            //if(!stack.isEmpty()) System.out.println(stack.peek());
            int currAsteroid = asteroids[idx];
            if(currAsteroid < 0 && !stack.isEmpty() && stack.peek() > 0){
                    int diff = stack.peek() - (-1*currAsteroid);
                    //System.out.println(diff);
                    if(diff == 0){
                        stack.pop();
                        idx++;
                    }
                    else if(diff < 0) stack.pop();
                    else{
                        idx++;
                    } 
            }
            else{
             stack.push(currAsteroid);
             idx++;
            }
        }
        
        int[] result = new int[stack.size()];
        int i=0;
        for(int asteroid : stack){
            result[i++] = asteroid;
        }
        
        return result;
    }
}

/*


[-2,2,-1,-2]
       i
 
 
 stack = [-2,2,]

if(asteroid < 0){
    if(!stack.isEmpty() && stack.peek() > 0){
        int diff = stack.peek() - (-1*asteroid){
        
        if(diff == 0){
          stack.pop(); index++;
        }
        }
    }
}



*/