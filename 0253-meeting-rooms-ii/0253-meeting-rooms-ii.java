class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        
        for(int i=0; i<n; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int endptr = 0, rooms = 0;
        
        for(int i=0; i<n; i++){
            if(start[i] < end[endptr]){
                rooms++;
            }
            else endptr++;
        }
        
        return rooms;
        
        
        
    }
}

/*

[0,5,15]
     i

[10,20,30]
     e


count = 2



*/