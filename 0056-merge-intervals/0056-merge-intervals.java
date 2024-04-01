class Solution {
    public int[][] merge(int[][] intervals) {
        
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        List<int[]> result = new ArrayList();
        
        int[] currInterval = intervals[0];
        result.add(currInterval);
        
        for(int[] interval : intervals){
            if(currInterval[1] >= interval[0]){
                currInterval[1] = Math.max(currInterval[1], interval[1]);
            }
            else{
                currInterval = interval;
                result.add(currInterval);
            }
        }
        
        return result.toArray(new int[result.size()][]);
        
        
    }
}