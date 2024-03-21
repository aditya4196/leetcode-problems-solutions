class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MyQueue() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        while(!stack2.isEmpty()) stack1.push(stack2.pop());
        stack1.push(x);
        while(!stack1.isEmpty()) stack2.push(stack1.pop());
    }
    
    public int pop() {
        return stack2.pop();
    }
    
    public int peek() {
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 
 
 queue = []
 
 [1,2,4]
 
 
 stack1 = [1,2]
 stack2 = [2,1]
 
 
 
 
 */