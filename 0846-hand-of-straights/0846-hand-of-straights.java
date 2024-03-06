class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length % groupSize != 0) return false;
        
        Map<Integer, Integer> map = new TreeMap();
        for(int val : hand){
            map.put(val, map.getOrDefault(val,0)+1);
        }
        
        for(int val : map.keySet()){
            int currNum = val;
            int currCount = map.get(val);
            if(currCount == 0) continue;
            
            for(int i=1; i<=groupSize; i++){
                if(!map.containsKey(currNum) || map.get(currNum) < currCount) return false;
                map.put(currNum, map.get(currNum) - currCount);
                currNum++;
            }
        }
        
        return true;
        
    }
}

/*


1 - 1
2 - 2
3 - 2
4 - 1
6 - 1
7 - 1
8 - 1


currCount = 1
currNum = 1





*/