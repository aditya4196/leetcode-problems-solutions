class Solution {
    public int totalStrength(int[] strength) {
        int n = strength.length;
        int[] leftIndex = new int[n];
        int[] rightIndex = new int[n];
        int mod = 1000000007;
        
        Arrays.fill(leftIndex,-1);
        Arrays.fill(rightIndex, n);
        Stack<Integer> stack = new Stack();
        
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && strength[stack.peek()] >= strength[i]){
                rightIndex[stack.pop()] = i;
            }
            stack.push(i);
        }
        
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && strength[stack.peek()] > strength[i]){
                leftIndex[stack.pop()] = i;
            }
            stack.push(i);
        }
        
        long[] preSum = new long[n+1];
        
        for(int i=1; i<=n; i++){
            preSum[i] = (preSum[i-1] + strength[i-1]) % mod;
        }
        
        long[] prepreSum = new long[n+2];
        for(int i=1; i<=preSum.length; i++){
            prepreSum[i] = (prepreSum[i-1] + preSum[i-1]) % mod;
        }
        
        long result = 0;
        
        for(int i=0; i<n; i++){
            int leftCount = i - leftIndex[i];
            int rightCount = rightIndex[i] - i;
            
            long rightSum = prepreSum[i+rightCount+1] - prepreSum[i+1];
            long leftSum = prepreSum[i+1] - prepreSum[i-leftCount+1];
            
            result = (result + (leftCount*rightSum - rightCount*leftSum) % mod * strength[i] % mod) % mod;
        }
        
        return (int)(result + mod)%mod;
    }
}