class Solution {
    public int maxTurbulenceSize(int[] arr) {
        
        
        //> : 1, < : -1, = : 0
        int sign = 0;
        int maxLength = 1, left = 0, right = 1;
        
        while(right < arr.length){
            if(arr[right-1] > arr[right] && sign != 1){
                maxLength = Math.max(maxLength, right-left+1);
                right++;
                sign = 1;
            }
            else if(arr[right-1] < arr[right] && sign != -1){
                maxLength = Math.max(maxLength, right-left+1);
                right++;
                sign = -1;
            }
            else{
                if(arr[right-1] == arr[right]) right++;
                left = right-1;
                sign = 0;
            }
        }
        
        return maxLength;
        
    }
}

/*

[9,4,2,10,7,8,8,1,9]
 e o e o  e o e o e
   i
 
 evenFlip = true;
 oddFlip = false;
*/