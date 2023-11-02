class Solution {
    public int[] findColumnWidth(int[][] grid) {
        List<Integer> result = new ArrayList();

        for(int j=0; j<grid[0].length; j++){
            int maxCount = 0;
            for(int i=0; i<grid.length; i++){
                maxCount = Math.max(maxCount, numlength(grid[i][j]));
            }
            result.add(maxCount);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int numlength(int num){
        
        if(num == 0) return 1;
        
        boolean neg = (num < 0)?true:false;
        num = Math.abs(num);
        int count = 0;
        while(num > 0){
            count++;
            num/=10;
        }
        
        if(neg) count+=1;
        return count;
    }
}