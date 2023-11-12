class SmallestInfiniteSet {

    int smallest;
    PriorityQueue<Integer> pq;
    HashSet<Integer> set;
    public SmallestInfiniteSet() {
        set = new HashSet<Integer>();
        pq = new PriorityQueue<Integer>();
        smallest = 1;
    }
    
    public int popSmallest() {
        if(pq.size() > 0){
            set.remove(pq.peek());
            return pq.poll(); 
        }
        else return smallest++;
    }
    
    public void addBack(int num) {
        if(num < smallest && !set.contains(num)){
            pq.offer(num);
            set.add(num);
        }
        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */