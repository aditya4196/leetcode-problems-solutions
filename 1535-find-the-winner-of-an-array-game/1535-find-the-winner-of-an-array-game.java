class Solution {
    public int getWinner(int[] arr, int k) {
        
        Deque<Integer> stack = new LinkedList();
        int count = 0;
        
        stack.push(arr[0]);
        
        for(int i=1; i<arr.length; i++){
            if(stack.peek() > arr[i]){
                count++;
            }
            else{
                stack.pop();
                stack.push(arr[i]);
                count = 1;
            }
            if(count == k) return stack.peek();
        }
        
        return stack.peek();
        
        
    }
}


/*


[2,1,3,5,4,6,7]

[]

count = 
*/