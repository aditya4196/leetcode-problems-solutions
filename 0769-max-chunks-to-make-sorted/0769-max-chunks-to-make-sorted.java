class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new LinkedList();
        
        for(int i=0; i<n; i++){
            int maxVal = -1;
            while(!stack.isEmpty() && stack.peek() > arr[i]){
                maxVal = Math.max(maxVal, stack.pop());
            }
            stack.push((maxVal == -1)?(arr[i]):(maxVal));
        }
        
        return stack.size();
       
        
    }
}


/*


4 3 2 1 0

stack = [4]





*/