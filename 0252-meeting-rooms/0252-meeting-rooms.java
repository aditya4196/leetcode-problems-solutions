class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int k = -1;
        for(int i=0; i<intervals.length; i++){
            int x = intervals[i][0];
            int y = intervals[i][1];
            
            if(x < k) return false;
            k = y;
        }
        
        return true;
        
    }
}