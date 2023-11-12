class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        
        Deque<Integer> stack = new LinkedList();
        
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        
        return result;
        
    }
}

