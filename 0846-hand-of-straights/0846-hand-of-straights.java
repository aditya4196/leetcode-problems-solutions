class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize != 0) return false;
        
        Map<Integer, Integer> handCount = new TreeMap();
        for(int val : hand){
            handCount.put(val, handCount.getOrDefault(val,0)+1);
        }
        
        for(int key : handCount.keySet()){
            int count = handCount.get(key);
            int currVal = key;
            if(count == 0) continue;
            
            for(int i=1; i<=groupSize; i++){
                if(!handCount.containsKey(currVal) || (handCount.get(currVal) < count)) return false;
                handCount.put(currVal, handCount.get(currVal)-count);
                currVal++;
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

count = 1


 [1,2,2,3,3,4,6,7,8]
[                   ]
condition1 = n is multiple of groupsize



n = 9
gs = 3


*/