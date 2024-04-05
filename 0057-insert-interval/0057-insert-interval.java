class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int idx = 0, n = intervals.length;
        List<int[]> result = new ArrayList();
        
        while(idx < n && newInterval[0] > intervals[idx][1]){
            result.add(intervals[idx]);
            idx++;
        }
        
        while(idx < n && intervals[idx][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }
        
        result.add(newInterval);
        
        while(idx < n){
            result.add(intervals[idx]);
            idx++;
        }
        
        return result.toArray(new int[result.size()][]);
    }
}

/*

[[1,2],[3,5],[6,7],[8,10],[12,16]]

 [4,8]




*/