class Solution {
    public int findMaxLength(int[] nums) {
        
        Map<Integer, Integer> countMap = new HashMap();
        int count = 0;
        countMap.put(0,-1);
        int maxLength = 0;
        
        for(int i=0; i<nums.length; i++){
            count += (nums[i] == 1)?1:-1;
            if(countMap.containsKey(count)){
                maxLength = Math.max(maxLength, i - countMap.get(count));
            }
            else countMap.put(count, i);
    
        }
        
        return maxLength;
        
        
        
    }
}


/*
     0 1 2 3
     
         i
    [0,1,0,0,1,1]
           
count = -1,0,-1,-2,-1,0


   
e
     s
zero = 1
ones = 0
    
Zer [0,1,1,2] 
One [0,0,1,1]
     i
         j
         
count = 1








*/