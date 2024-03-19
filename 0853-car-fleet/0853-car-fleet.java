class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        Map<Integer, Double> posTimeMap = new TreeMap(Collections.reverseOrder());
        
        for(int i=0; i<n; i++){
            posTimeMap.put(position[i], ((double)target - (double)position[i])/speed[i]);
        }
        double candidate = 0;
        int carFleet = 0;
        
        for(double time : posTimeMap.values()){
            if(candidate < time){
                carFleet++;
                candidate = time;
            }
        }
        
        return carFleet;
        
        
    }
}