class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        //build the graph
        
        HashMap<String, HashMap<String, Double>> adjlist = new HashMap();
        
        for(int i=0; i<equations.size(); i++){
            List<String> equation = equations.get(i);
            String dividend = equation.get(0), divisor = equation.get(1);
            double value = values[i];
            
            adjlist.computeIfAbsent(dividend, k-> new HashMap<String, Double>()).put(divisor, value);
            adjlist.computeIfAbsent(divisor, k-> new HashMap<String, Double>()).put(dividend, 1/value);
        }
        
        //dfs on queries
        double[] result = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            List<String> query = queries.get(i);
            String dividend = query.get(0), divisor = query.get(1);
            
            if(!adjlist.containsKey(dividend) || !adjlist.containsKey(divisor)) result[i] = -1.0;
            else if(dividend.equals(divisor)) result[i] = 1.0;
            else{
                HashSet<String> visited = new HashSet<String>();
                result[i] = dfs(adjlist, dividend, divisor, 1.0, visited);
            }
        }
        
        return result;
    }
    
    public double dfs(HashMap<String, HashMap<String, Double>> adjlist, String curr, String end, double product, HashSet<String> visited)     {
        double ret = -1.0;
        visited.add(curr);
        
        HashMap<String, Double> nextNodes = adjlist.get(curr);
        
        //base case
        if(nextNodes.containsKey(end)){
            ret = (product*nextNodes.get(end));
        }
        else{
            for(String next : nextNodes.keySet()){
                if(visited.contains(next)) continue;
                ret = dfs(adjlist, next, end, product*nextNodes.get(next), visited);
                if(ret != -1.0) break;
            }
        }
        visited.remove(curr);
        return ret;
    }
}

/*

a -> b



*/