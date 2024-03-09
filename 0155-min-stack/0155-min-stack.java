class MinStack {

    private Stack<Pair<Integer,Integer>> minStack;
    public MinStack() {
        minStack = new Stack<Pair<Integer, Integer>>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty()){
            minStack.push(new Pair(val, val));
        }
        else minStack.push(new Pair(val, Math.min(val, minStack.peek().getValue())));
    }
    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek().getKey();
    }
    
    public int getMin() {
        return minStack.peek().getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 
 stack = [(-2,-2),(0,-2)]
 
 [-3]
 
 */