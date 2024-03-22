class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int[] result = new int[n];
        
        for(int[] booking : bookings){
            int start_idx = booking[0]-1;
            int end_idx = booking[1]-1;
            int count = booking[2];
            
            result[start_idx] += count;
            if(end_idx < (n-1)) result[end_idx+1] -= count;
        }
        
        for(int i=1; i<n; i++){
            result[i] += result[i-1];
        }
        
        return result;
        
    }
}

/*
[[1,2,10],[2,3,20],[2,5,25]]

 0 1 2 3 4
[10,45,-10,-20,0]


[10,55,45,25,25]

*/