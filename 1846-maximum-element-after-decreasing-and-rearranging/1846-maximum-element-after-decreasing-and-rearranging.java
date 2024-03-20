class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int maxNum = 1;
        arr[0] = 1;
        for(int i=1; i<arr.length; i++){
            int diff = Math.abs(arr[i]-arr[i-1]);
            if(diff > 1) arr[i] = arr[i-1] + 1;
            maxNum = Math.max(maxNum, arr[i]);
        }
        
        return maxNum;
        
        
    }
}


/*

[5,11,14,3,2]
[2,3,5,11,14]

[1,2,3,4,5]




[100,1,1000]

[1,100,1000]



*/