class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int k = Integer.MIN_VALUE;
        int n = intervals.length;
        int result = 0;
        
        for(int i=0; i<n; i++){
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            
            if(nextStart >= k) k = nextEnd;
            else result++;
        }
        
        return result;
    }
}

/*





*/