class SmallestInfiniteSet {

    int smallest;
    PriorityQueue<Integer> pq;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<Integer>();
        smallest = 1;
    }
    
    public int popSmallest() {
        if(pq.size() > 0){
            return pq.poll(); 
        }
        else return smallest++;
    }
    
    public void addBack(int num) {
        if(num < smallest && !pq.contains(num)){
            pq.offer(num);
        }
        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */