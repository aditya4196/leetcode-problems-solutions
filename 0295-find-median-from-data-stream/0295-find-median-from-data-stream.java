class MedianFinder {

    PriorityQueue<Integer> leftArr, rightArr;
    int size;
    public MedianFinder() {
        leftArr = new PriorityQueue<Integer>();
        rightArr = new PriorityQueue<Integer>(Collections.reverseOrder());
        this.size = 0;
    }
    
    public void addNum(int num) {
        rightArr.offer(num);
        leftArr.offer(rightArr.poll());
        if(leftArr.size() > (rightArr.size() +1)){
            rightArr.offer(leftArr.poll());
        }
        size++;
    }
    
    public double findMedian() {
        if(size%2 == 0){
            return (double)(leftArr.peek() + rightArr.peek())/2;
        }
        else return leftArr.peek();
    }
}

/**
1, -1, -2

[-1,-2] | [1]

 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */