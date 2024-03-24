class Solution {
    public int maxTurbulenceSize(int[] arr) {
        
        int right = 1, left = 0;
        int maxlen = 1;
        int sign = 0;
        
        while(right < arr.length){
            if(arr[right-1] > arr[right] && sign != 1){
                maxlen = Math.max(maxlen, right-left+1);
                right++;
                sign = 1;
            }
            else if(arr[right-1] < arr[right] && sign != -1){
                maxlen = Math.max(maxlen, right-left+1);
                right++;
                sign = -1;
            }
            else{
                if(arr[right-1] == arr[right]) right+=1;
                left = right-1;
                sign = 0;
            }
        }
        
        return maxlen;
        
        
        
    }
}