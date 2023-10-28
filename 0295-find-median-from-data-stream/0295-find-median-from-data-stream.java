class MedianFinder {
    
    PriorityQueue<Integer> maxpq;
    PriorityQueue<Integer> minpq;
    
    public MedianFinder() {
        maxpq = new PriorityQueue<Integer>((a,b)->(b-a));
        minpq = new PriorityQueue<Integer>((a,b)->(a-b));
    }
    
    public void addNum(int num) {
        if(maxpq.size() == 0){
            maxpq.offer(num);
            return;
        }
        if(num > maxpq.peek()){
            minpq.offer(num);
        }
        else maxpq.offer(num);
        
        int maxsize = maxpq.size();
        int minsize = minpq.size();
        
        if((maxsize + minsize)%2 != 0 && minsize > maxsize){
            maxpq.offer(minpq.poll());
        }
        else if((maxsize + minsize)%2 == 0 && maxsize > minsize){
            minpq.offer(maxpq.poll());
        }
    }
    
    public double findMedian() {
        if(maxpq.size() == minpq.size()) return (double)(maxpq.peek() + minpq.peek())/2;
        else return maxpq.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/*

1 4 6 7 4 2 1

1 4

[1, 4] - [6]          




*/