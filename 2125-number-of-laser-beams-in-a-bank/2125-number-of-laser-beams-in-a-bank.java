class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        
        int[] laserCount = new int[n];
        List<Integer> laserIndexes = new ArrayList();
        
        for(int j=0; j<bank.length; j++){
            String row = bank[j];
            int lasers = 0;
            for(int i=0; i<row.length(); i++){
                lasers += (row.charAt(i) == '1') ? 1 : 0;
            }
            if(lasers > 0){
                laserIndexes.add(j);
                laserCount[j] = lasers;
            }
        }
        
        int totalLasers = 0;
        
        for(int k=0; k<laserIndexes.size()-1; k++){
            int upper = laserIndexes.get(k);
            int lower = laserIndexes.get(k+1);
            
            totalLasers += (laserCount[upper]*laserCount[lower]);
            
        }
        
        return totalLasers;
        
        
        
        
        
        
        
    }
}