class Solution {
    public long maximumBooks(int[] books) {
        
        int n = books.length;
        
        //find how far in backward direction can be considered for current to be max
        int[] adjusted = new int[n];
        for(int i=0; i<n; i++) adjusted[i] = books[i] - i;
        
        //find the leftindex of immediate smaller value for current index
        int[] leftSmaller = new int[n];
        Arrays.fill(leftSmaller, -1);
        
        Deque<Integer> stack = new LinkedList();
        
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && adjusted[stack.peek()] >= adjusted[i]){
                stack.pop();
            }
            
            if(!stack.isEmpty()) leftSmaller[i] = stack.peek();
            stack.push(i);
        }
        
        long[] dp = new long[n];
        
        for(int i=0; i<n; i++){
            //arithmetic progression sum formula = Sn = (a1 + an)*n/2
            
            int an = books[i];
            int count = Math.min(books[i], i - leftSmaller[i]);
            int a1 = an - count + 1;
            long sum = (long)(a1 + an)*count/2;
            
            dp[i] = sum + ((leftSmaller[i] == -1)?(0):dp[leftSmaller[i]]);
            
        }
        
        return Arrays.stream(dp).max().getAsLong();
        
    }
}