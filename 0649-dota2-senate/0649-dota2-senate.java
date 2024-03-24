class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Integer> rqueue = new LinkedList();
        Deque<Integer> dqueue = new LinkedList();
        
        for(int i=0; i<senate.length(); i++){
            if(senate.charAt(i) == 'R'){
                rqueue.offer(i);
            }
            else{
                dqueue.offer(i);
            }
        }
        int n = senate.length();
        
        while(rqueue.size() > 0 && dqueue.size() > 0){
            int ridx = rqueue.poll();
            int didx = dqueue.poll();
            if(ridx < didx){
                rqueue.offer(ridx+n);
            }
            else dqueue.offer(didx+n);
        }
        
        return (rqueue.size() > 0)?"Radiant":"Dire";
       
    }
}

/*

0123456789
RDDRDRRDDR






radiant =
dire = 




*/