class Solution {
    public String predictPartyVictory(String senate) {
        
        int n = senate.length();
        Deque<Integer> rqueue = new LinkedList();
        Deque<Integer> dqueue = new LinkedList();
        
        for(int i=0; i<n; i++){
            if(senate.charAt(i) == 'R') rqueue.offer(i);
            else dqueue.offer(i);
        }
        
        
        while(rqueue.size() > 0 && dqueue.size() > 0){
            if(rqueue.peek() < dqueue.peek()){
                rqueue.offer(n++);
            }
            else dqueue.offer(n++);
            rqueue.poll();
            dqueue.poll();
        }
        
        return (rqueue.size() == 0)?"Dire":"Radiant";
     

    }
}

/*

RDDRRD
012345
 
queueR = {}
queueD = {7,9,10}






*/