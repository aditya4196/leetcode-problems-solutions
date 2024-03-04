class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int totalGas = 0, start = 0, currGas = 0;
        
        for(int i=0; i<gas.length; i++){
            currGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];
            
            if(currGas < 0){
                start = i+1;
                currGas = 0;
            }
        }
        
        return (totalGas < 0)?-1:start;
        
        
    }
}

/*

gas =  [1,2,3,4,5]
        i
cost = [3,4,5,1,2]
        j
        
gas - cost = [-2,-2,-2,3,3]
 
  0  1  2 3 4
[-2,-2,-2,3,3]


            
totalTank = -3 
index = 
*/