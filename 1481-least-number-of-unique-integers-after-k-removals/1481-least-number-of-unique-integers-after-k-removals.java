class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        HashMap<Integer,Integer> countMap = new HashMap();
        for(int val : arr){
            countMap.put(val, countMap.getOrDefault(val,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> (countMap.get(a) - countMap.get(b)));
        
        for(int uniqueVal : countMap.keySet()){
            pq.offer(uniqueVal);
        }
        
        int removedCount = 0;
        
        while(pq.size() > 0 && removedCount < k){
            int removedValue = pq.poll();
            int count = countMap.get(removedValue);
            if(count > (k - removedCount)){
                return pq.size()+1;
            }
            else removedCount += count;
        }
        
        return pq.size();
        
        
    }
}

/*
 questions - would there be a case where k values are more than the number of elements
 

[5,5,4]

[4,3,1,1,3,3,2]

4 - 1
3 - 3
1 - 2
2 - 1

1,2,3,4

pq = [1]



*/