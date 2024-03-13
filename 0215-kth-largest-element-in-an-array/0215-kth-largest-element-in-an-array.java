class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> (a - b));
        
        for(int num : nums){
            pq.offer(num);
            if(pq.size() > k) pq.poll();
        }
        
        return pq.poll();
        
    }
}

/*


[3,2,1,5,6,4]
[1,2,3,4,5,6]
pq = (4,6,5)



*/