class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        int i=0, j=0;
        int n1 = firstList.length, n2 = secondList.length;
        List<int[]> result = new ArrayList();
        
        while(i < n1 && j < n2){
            int leftMax = Math.max(firstList[i][0], secondList[j][0]);
            int rightMin = Math.min(firstList[i][1], secondList[j][1]);
            
            if(leftMax <= rightMin){
                result.add(new int[]{leftMax, rightMin});
            }
            
            if(firstList[i][1] >= secondList[j][1]) j++;
            else i++;
        }
        
        return result.toArray(new int[result.size()][]);
        
    }
}

/*

[[0,2],[5,10],[13,23],[24,25]]
  

[[1,5],[8,12],[15,24],[25,26]]


[]


*/