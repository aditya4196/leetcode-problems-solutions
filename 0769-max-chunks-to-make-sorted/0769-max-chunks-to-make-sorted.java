class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new LinkedList();
        
        for(int i=0; i<n; i++){
            Integer maxVal = -1;
            while(!stack.isEmpty() && stack.peek() > arr[i]){
                maxVal = Math.max(maxVal, stack.pop());
            }
            if(maxVal != -1){
                stack.push(maxVal);
            }
            else stack.push(arr[i]);
        }
        
        
        return stack.size();
       
        
    }
}


/*


4 3 2 1 0

4 4 4 4 4
        0





*/