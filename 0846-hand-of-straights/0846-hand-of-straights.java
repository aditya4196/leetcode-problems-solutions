class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        int n = hand.length;
        Map<Integer, Integer> map = new HashMap();
        Arrays.sort(hand);
        
        for(int h : hand){
            map.put(h, map.getOrDefault(h,0)+1);
        }
        
        for(int i=0; i<n; i++){
            if(!map.containsKey(hand[i]) || map.get(hand[i]) == 0) continue;
            int currNum = hand[i];
            int currCount = map.get(currNum);
        
        
            for(int j=1; j<=groupSize; j++){
                if(!map.containsKey(currNum) || currCount > map.get(currNum)) return false;
                map.put(currNum, map.get(currNum)-currCount);
                currNum++;
            }
        }
        
        return true;
        
    }
}

/*

[1,2,3,6,2,3,4,7,8]
[1,2,2,3,3,4,6,7,8]

   i
 
 [1,2,3],[2,3,]


map :
1 - 0
2 - 0
3 - 0
4 - 1
6 - 1
7 - 1
8 - 1




*/