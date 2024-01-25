class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        
        return result;
        
    }
}

/*

[73, 74, 75, 71, 69, 72, 76, 73]
 0   1.  2.  3.  4.  5.  6.  7
 
stack = []

*/
