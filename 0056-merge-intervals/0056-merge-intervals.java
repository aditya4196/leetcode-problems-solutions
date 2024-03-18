class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList();
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        
        int[] currInterval = intervals[0];
        result.add(currInterval);
        
        for(int i=0; i<intervals.length; i++){
            int[] interval = intervals[i];
            if(currInterval[1] >= interval[0]){
                currInterval[1] = Math.max(currInterval[1], interval[1]);
            }
            else{
                result.add(interval);
                currInterval = interval;
            }
        }
        
        return result.toArray(new int[result.size()][]);
        
    }
}