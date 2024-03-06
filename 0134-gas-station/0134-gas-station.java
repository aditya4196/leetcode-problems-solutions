class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int totalGas = 0;
        int localGas = 0;
        int start = 0;
        
        for(int i=0; i<gas.length; i++){
            localGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];
            
            if(localGas < 0){
                start = i+1;
                localGas = 0;
            }
        }
        
        return (totalGas < 0)?-1:start;
        
    }
}