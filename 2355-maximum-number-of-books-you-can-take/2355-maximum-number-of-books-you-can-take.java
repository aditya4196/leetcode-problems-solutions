class Solution {
    public long maximumBooks(int[] books) {
        int n = books.length;
        Stack<Integer> stack = new Stack<Integer>();
        
        int[] leftMinIndex = new int[n];
        Arrays.fill(leftMinIndex, -1); 
        
        int[] adjusted = new int[n];
        for(int i=0; i<n; i++){
            adjusted[i] = books[i] - i;
        }
        
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && adjusted[stack.peek()] >= adjusted[i]){
                stack.pop();
            }
            
            if(!stack.isEmpty()) leftMinIndex[i] = stack.peek();
            stack.push(i);
        }
        
        long[] dp = new long[n+1];
        long maxBooks = 0;
        
        for(int i=0; i<n; i++){
            long an = books[i];
            long count = Math.min(books[i], i - leftMinIndex[i]);
            long a1 = books[i] - count + 1;
            long sum = (an + a1)*count/2;
            dp[i] = sum + ((leftMinIndex[i] == -1)?0:(dp[leftMinIndex[i]]));
            maxBooks = Math.max(maxBooks, dp[i]);
        }
        
        return maxBooks;
        
        
        
        
        
        
    }
}

/*

 0 1 2 3 4
[8,5,4,3,4]

[8,4,0,4,5]
   i
 
stack = [8] 







   i
[8,0,0,0,0]
 
stack = [0] 
 

arithmetic sum = 
a1 = 4
an = 5
n = 









*/