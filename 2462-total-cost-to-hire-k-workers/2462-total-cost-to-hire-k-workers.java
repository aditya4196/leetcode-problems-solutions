class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
        int n = costs.length;
        PriorityQueue<Integer> pqleft = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pqright = new PriorityQueue<Integer>();
        
        for (int i = 0; i < candidates; i++) {
            pqleft.add(costs[i]);
        }
        for (int i = Math.max(candidates, n-candidates); i<n; i++) {
            pqright.add(costs[i]);
        }
        
        long result = 0;
        int left = candidates, right = n-candidates-1;
        

        for(int i=0; i<k; i++){
            if(pqright.isEmpty() || (!pqleft.isEmpty() && pqleft.peek() <= pqright.peek())){
                result += (long)(pqleft.poll());
                if(left <= right){
                    pqleft.offer(costs[left++]);
                }  
            }
            else{
                result += (long)(pqright.poll());
                if(left <= right){
                    pqright.offer(costs[right--]);
                } 
            }
        }
        
    return result;
    }  
}

/*

k = 3
cand = 4
[1,2,4,1]
            i
            j
 
pqleft = 17,12,10,7
pqright = 11,20,8

2+2+7
 



*/