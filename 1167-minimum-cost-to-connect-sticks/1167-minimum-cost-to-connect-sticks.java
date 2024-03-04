class Solution {
    public int connectSticks(int[] sticks) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        for(int stick : sticks) queue.offer(stick);
        int totalCost = 0;
        
        while(queue.size()>1){
            int stick1 = queue.poll();
            int stick2 = queue.poll();
            totalCost += stick1 + stick2;
            queue.offer(stick1 + stick2);
        }
        
        return totalCost;
        
    }
}

/*


[1,1,1,8,9,10] = 11
[11,1,1,8,9] = 12
[12,1,9,8] = 11
[11,9,10] = 11
[11,19] = 19
[30] = 30

20 + 30 + 10 + 19


 





*/