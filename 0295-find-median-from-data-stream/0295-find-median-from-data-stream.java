class MedianFinder {

    private PriorityQueue<Integer> maxLeft;
    private PriorityQueue<Integer> minRight;

    
    public MedianFinder() {
        maxLeft = new PriorityQueue<Integer>((a,b)->(b-a));
        minRight = new PriorityQueue<Integer>((a,b)->(a-b));

        
    }
    
    public void addNum(int num) {
        if(maxLeft.size() == 0){
            maxLeft.offer(num);
            return;
        }
        
        if(num < maxLeft.peek()) maxLeft.offer(num);
        else minRight.offer(num);
        
        int leftsize = maxLeft.size();
        int rightsize = minRight.size();
        
        if((leftsize + rightsize)%2 != 0 && rightsize > leftsize) maxLeft.offer(minRight.poll());
        else if((leftsize + rightsize)%2 == 0 && leftsize > rightsize) minRight.offer(maxLeft.poll());
    }
    
    public double findMedian() {
        
        if(minRight.size() == maxLeft.size()) return (double)(maxLeft.peek() + minRight.peek())/2;
        else return maxLeft.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


/*

minpq(right) = 3  
maxpq(left) = 1


/*
  6 or 2

                 2  |.  6




*/


