class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int minIndex = 0, minEle = nums[0];
        int maxIndex = 0, maxEle = nums[0];

        
        for(int i=0; i<n; i++){
            
            if(minEle > nums[i]){
                minEle = nums[i];
                minIndex = i;
            }
            if(maxEle <= nums[i]){
                maxEle = nums[i];
                maxIndex = i;
            }
        }
        
        return (n - maxIndex - 1) + (minIndex) - ((maxIndex < minIndex)?1:0);
        
    }
}

/*
 0 1 2 3 4 5
[3,4,5,5,3,1]
 
       j
           i
           
           
minIndex = 5
minEle = 1

maxIndex = 3
maxEle = 5



           
        
*/