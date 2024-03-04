class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        Arrays.sort(costs, (a,b) -> ((a[0] - a[1]) - (b[0] - b[1])));
        int mid = costs.length/2, result = 0;
        
        for(int i=0; i<costs.length; i++){
            if(i < mid) result += costs[i][0];
            else result += costs[i][1];
        }
        
        return result;
        
    }
}

/*

 A.  B
[10,20],
[30,200],
[400,50],
[30,20]



*/