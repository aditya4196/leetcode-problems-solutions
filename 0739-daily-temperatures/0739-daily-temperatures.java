class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> indStack = new Stack<Integer>();
        
        for(int i=0; i<n; i++){
            while(!indStack.isEmpty() && temperatures[i] > temperatures[indStack.peek()]){
                result[indStack.peek()] = i - indStack.pop();
            }
            indStack.push(i);
        }
        
        return result;
        
        
    }
}