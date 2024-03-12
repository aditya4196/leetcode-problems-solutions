class Solution {
    public long maximumBooks(int[] books) {
        int n = books.length;
        Deque<Integer> stack = new LinkedList();
        long[] dp = new long[n];
        
        for(int i=0; i<n; i++){
            
            while(!stack.isEmpty() && (books[stack.peek()] - stack.peek()) >= (books[i] - i)){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                dp[i] = calculateCount(books, 0, i);
            }
            else dp[i] = dp[stack.peek()] + calculateCount(books, stack.peek()+1, i);
            
            stack.push(i);
        }
        
       return Arrays.stream(dp).max().getAsLong();
    }
    
    public long calculateCount(int[] books, int left, int right){
        long factor = Math.min(books[right], right-left+1);
        return (2*books[right] - (factor - 1))*factor/2;
        
    }
}

/*
 0 1 2 3 4

 0 1 2 3 4
[8,5,2,7,9]
   i

stack = [0]
calculateSum = 




 
[        0,0,2,2,5]
 
 
 

[[2,2],[2,2],[2,2],[7,3][9,4]]
   0.    1.    



*/