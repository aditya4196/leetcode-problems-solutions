class Solution {
    public long maximumBooks(int[] books) {
        int n = books.length;
        int[] adjusted = new int[n];
        
        for(int i=0; i<n; i++) adjusted[i] = books[i] - i;
        Deque<Integer> stack = new LinkedList();
        int[] leftSmaller = new int[n];
        Arrays.fill(leftSmaller, -1);
        
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && adjusted[stack.peek()] >= adjusted[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) leftSmaller[i] = stack.peek();
            stack.push(i);
        }
        
        long[] dp = new long[n];
        
        for(int i=0; i<n; i++){
            int count = Math.min(books[i], i-leftSmaller[i]);
            int start = books[i] - count + 1;
            int bookCount = books[i];
            
            long sum = (long)(start + bookCount)*count/2;
            dp[i] = sum + ((leftSmaller[i] == -1)?0:dp[leftSmaller[i]]);
        }
        
        
        return Arrays.stream(dp).max().getAsLong();
        
        
        
    }
}