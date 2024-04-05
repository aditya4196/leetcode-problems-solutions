class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] avail = new int[n];
        
        for(int i=0; i<n; i++){
            avail[i] = gas[i] - cost[i];
        }
        
        int currGas = 0, totalGas = 0;
        int candidate = 0;
        
        for(int i=0; i<n; i++){
            currGas += avail[i];
            totalGas += avail[i];
            
            if(currGas < 0){
                currGas = 0;
                candidate = i+1;
            }
        }
        
        return (totalGas < 0)?-1:candidate;
        
        
    }
}