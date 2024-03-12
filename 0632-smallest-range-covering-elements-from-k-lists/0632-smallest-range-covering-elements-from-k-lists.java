class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        List<Pair<Integer,Integer>> sortedList = new ArrayList();
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer,Integer>>((a,b) -> (a.getKey() - b.getKey()));
        Map<Integer, Integer> indexMap = new HashMap();
        
        for(int i=0; i<nums.size(); i++){
            pq.offer(new Pair<Integer, Integer>(nums.get(i).get(0), i));
            indexMap.put(i,0);
        }
        
        
        
        
        while(pq.size() > 0){
            Pair<Integer, Integer> currPair = pq.poll();
            sortedList.add(currPair);
            
            int idx = currPair.getValue();
            indexMap.put(idx, indexMap.get(idx)+1);
            if(indexMap.get(idx) >= nums.get(idx).size()) continue;

            Pair<Integer,  Integer> nextPairToOffer = new Pair<Integer, Integer>(nums.get(idx).get(indexMap.get(idx)), idx);
            pq.offer(nextPairToOffer);
        }
        
        
        //sliding window
        
        int start = 0, count = 0;
        int k = nums.size();
        int n = sortedList.size();
        
        int[] groupCount = new int[k];
        int minstart = 0, minend = n;
        int minLength = Integer.MAX_VALUE;
        
        for(int end=0; end<n; end++){
            Pair<Integer, Integer> currPair = sortedList.get(end);
            int egroup = currPair.getValue();
            int evalue = currPair.getKey();
        
            if(groupCount[egroup]++ == 0) count++;
            
            while(count == k){
                
                int left = sortedList.get(start).getKey();
                int right = sortedList.get(end).getKey();
                System.out.println(left + "-" + right);
                if(minLength > (right-left+1)){
                    minLength = right-left+1;
                    minend = end;
                    minstart = start;
                }
                
                Pair<Integer, Integer> startPair = sortedList.get(start);
                int sgroup = startPair.getValue();
                int svalue = startPair.getKey();
                
                if(--groupCount[sgroup] == 0) count--;
                start++;
            }
        }
        
        
        
        System.out.println(sortedList);
        return new int[]{sortedList.get(minstart).getKey(), sortedList.get(minend).getKey()};
    }
}


/*


[4,10,15,24,26]

 
[0,9,12,20]
   
 
[5,18,22,30]


[[0,0],[]]



set = (2,0)
start = 0
end = 4
*/