class FreqStack {

    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> groupMap;
    int maxFreq;
    
    public FreqStack() {
        freqMap = new HashMap();
        groupMap = new HashMap();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int currfreq = freqMap.getOrDefault(val,0)+1;
        freqMap.put(val, currfreq);
        if(currfreq > maxFreq) maxFreq = currfreq;
        
        groupMap.computeIfAbsent(currfreq, k -> new Stack<Integer>()).push(val);
    }
    
    public int pop() {
        int popped = groupMap.get(maxFreq).pop();
        freqMap.put(popped, freqMap.get(popped)-1);
        if(groupMap.get(maxFreq).size() == 0) maxFreq--;
        return popped;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */