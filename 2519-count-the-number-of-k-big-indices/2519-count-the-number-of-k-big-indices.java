class Solution {
    public int kBigIndices(int[] nums, int k) {
        int n = nums.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> (b-a));
        boolean[] left = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(pq.size() == k && pq.peek() < nums[i]){
                left[i] = true;
            }
            pq.offer(nums[i]);
            if(pq.size() > k) pq.poll();
        }
        
        pq.clear();
        
        int count = 0;
        
        for(int i=n-1; i>=0; i--){
            if(pq.size() == k && pq.peek() < nums[i]){
                if(left[i] == true) count++;
            }
            pq.offer(nums[i]);
            if(pq.size() > k) pq.poll();
        }
        
        return count;
        
        
        
    }
}

/*

k = 2

 0 1 2 3 4 5
[2,3,6,5,2,3]
       i
[F,F,T,T,F,F]

pq = (3,2)

 
stack = []




*/