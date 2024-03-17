class MedianFinder {
    
    private int size;
    private PriorityQueue<Integer> maxLeft, minRight;

    public MedianFinder() {
        this.size = 0;
        maxLeft = new PriorityQueue<Integer>((a,b)->(b-a));
        minRight = new PriorityQueue<Integer>((a,b)->(a-b));
    }
    
    public void addNum(int num) {
        if(maxLeft.size() == 0){
            maxLeft.offer(num);
            this.size+=1;
            return;
        }
        
        if(num < maxLeft.peek()) maxLeft.offer(num);
        else minRight.offer(num);
        this.size += 1;
        
        int leftSize = maxLeft.size();
        int rightSize = minRight.size();
        
        if(this.size%2 == 0 && leftSize > rightSize){
            minRight.offer(maxLeft.poll());
        }
        else if(this.size%2 != 0 && rightSize > leftSize){
                maxLeft.offer(minRight.poll());
            }
    }

    public double findMedian() {
        if(this.size%2 == 0){
            return ((double)maxLeft.peek() + minRight.peek())/2;
        }   
        else return maxLeft.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 
 
 add 1, 
 
 [1,2,0] | [3]
 
 size = 1
 
 */