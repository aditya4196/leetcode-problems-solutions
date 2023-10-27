class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> output = new ArrayList();
        
        int fptr = 0, sptr = 0;
        
        while(fptr < firstList.length && sptr < secondList.length){
            int fstart = firstList[fptr][0];
            int fend = firstList[fptr][1];
            int sstart = secondList[sptr][0];
            int send = secondList[sptr][1];
            
            int intStart = Math.max(fstart, sstart);
            int intEnd = Math.min(fend, send);
            
            if(intEnd >= intStart){
                output.add(new int[]{intStart, intEnd});
            }
            
            if(fend >= send){
                sptr++;
            }
            else fptr++;
        }
        
        return output.toArray(new int[output.size()][]);
        
        
        
        
    }
}

/*

[0,2],[5,10],[13,23],[24,25]
[1,5],[8,12],[15,24],[25,26]


*/