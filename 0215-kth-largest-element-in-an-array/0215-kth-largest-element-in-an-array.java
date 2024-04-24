class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int maxbucketSize = Integer.MIN_VALUE, minbucketSize = Integer.MAX_VALUE;
        Map<Integer,Integer> bucketMap = new HashMap();
        
        for(int num : nums){
            maxbucketSize = Math.max(maxbucketSize, num);
            minbucketSize = Math.min(minbucketSize, num);
            bucketMap.put(num, bucketMap.getOrDefault(num,0)+1);
        }
        
        int traversed = 0;
        for(int bucket = maxbucketSize; bucket>=minbucketSize; bucket--){
            
            int currCount = bucketMap.getOrDefault(bucket,-1);
            if(currCount == -1) continue;
            
            traversed += currCount;
            if(traversed >= k) return bucket;
        }
        
        return -1;
        
    }
}

/*

1,2,2,3,3,4,5,5,6

max number = 6

1 2 3 4 5 6
1 2 2 1 2 1




*/