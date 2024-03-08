class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int left = 0, right = arr.length-1;
        
        while(left < right){
            int mid = left + (right-left)/2;
            if(mid < arr.length-1 && arr[mid] > arr[mid+1]) right = mid;
            else left = mid+1;
                
        }
        
        return left;
        
    }
}

/*


0,5,10,2
     m
     l
       r





*/