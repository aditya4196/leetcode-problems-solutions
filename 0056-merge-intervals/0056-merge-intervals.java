class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        List<int[]> output = new ArrayList();
        int[] currInterval = intervals[0];
        output.add(currInterval);
        
        for(int[] interval : intervals){
            if(currInterval[1] >= interval[0]){
                currInterval[1] = Math.max(currInterval[1], interval[1]);
            }
            else{
                output.add(interval);
                currInterval = interval;
            }
        }
        
        return output.toArray(new int[output.size()][]);
        
    }
}