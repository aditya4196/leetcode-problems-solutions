class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int maxVal = -1, result = 0;
        
        for(int i=0; i<n; i++){
            maxVal = Math.max(maxVal, arr[i]);
            if(maxVal == i) result++;
        }
        
        return result;
    }
}


/*


4 3 2 1 0

4 4 4 4 4
        0





*/