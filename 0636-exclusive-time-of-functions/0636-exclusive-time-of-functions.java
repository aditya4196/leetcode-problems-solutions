class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        int[] result = new int[n];
        Stack<FunctionLog> logstack = new Stack<FunctionLog>();
        
        for(String log : logs){
            FunctionLog flog = new FunctionLog(log);
            if(flog.isStart){
                logstack.push(flog);
            }
            else{
                int execTime = flog.time - logstack.peek().time + 1;
                result[logstack.pop().id] += execTime;
                
                if(!logstack.isEmpty()){
                    result[logstack.peek().id] -= execTime;
                }
            }
            
        }
        
        return result;
        
        
    }
    
}

class FunctionLog{
    int id;
    boolean isStart;
    int time;
    
    public FunctionLog(String log){
        String[] logSplit = log.split(":");
        this.id = Integer.parseInt(logSplit[0]);
        this.isStart = (logSplit[1].equals("start"))?true:false;
        this.time = Integer.parseInt(logSplit[2]);
    }
    
    
}