class MedianFinder {
    
    
    private PriorityQueue<Integer> maxQueue;
    private PriorityQueue<Integer> minQueue;
    private int size;
    
    public MedianFinder() {
        this.maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        this.minQueue = new PriorityQueue<Integer>();
        this.size = 0;
    }
    
    public void addNum(int num) {
        size++;
        maxQueue.offer(num);
        minQueue.offer(maxQueue.poll());
        if(minQueue.size() > maxQueue.size()){
            maxQueue.offer(minQueue.poll());
        }
    }
    
    public double findMedian() {
        if(size%2 != 0){
            return (double)maxQueue.peek();
        }
        else{
            return ((double)maxQueue.peek() + (double)minQueue.peek())/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/*


[1,2|3]





*/