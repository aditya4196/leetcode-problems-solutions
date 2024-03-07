class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> (b-a));
        Map<Integer, Integer> indexMap = new HashMap();
        
        for(int i=0; i<k; i++){
            pq.offer(nums[i]);
            indexMap.put(nums[i], i);
        }
        
        int[] output = new int[nums.length-k+1];
        output[0] = pq.peek();
        
        for(int end=k; end<nums.length; end++){
            
            while(pq.size() > 0 && indexMap.get(pq.peek()) <= (end-k)) pq.poll();
            
            indexMap.put(nums[end],end);
            pq.offer(nums[end]);
            
            output[end-k+1] = pq.peek();
        }
        
        return output;
        
        
        
        
    }
}

/*

[1,3,-1,-3,5,3,6,7]
 0 1  2  3.4 5 6 7
         e

[1] 
pq = {1,3,-1}
map = 1 - 0, 3 - 1, -1 - 2

 
 


  


*/