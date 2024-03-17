class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        
        Project[] projects = new Project[n];
        for(int i=0; i<n; i++){
            projects[i] = new Project(profits[i], capital[i]);
        }
        
        Arrays.sort(projects);
        PriorityQueue<Integer> maxProfitQueue = new PriorityQueue<Integer>((a,b)->(b-a));
        int avail_ptr = 0;
        
        for(int i=0; i<k; i++){
            while(avail_ptr < n && projects[avail_ptr].capital <= w){
                //w -= projects[avail_ptr].capital;
                maxProfitQueue.offer(projects[avail_ptr].profit);
                avail_ptr++;
            }
            
            if(maxProfitQueue.size() == 0) break;
            else{
                w += maxProfitQueue.poll();
            }
        }
        
        return w;
        
        
        
    }
}


class Project implements Comparable<Project>{
    int profit;
    int capital;
    
    public Project(int profit, int capital){
        this.profit = profit;
        this.capital = capital;
    }
    
    public int compareTo(Project project){
        return this.capital - project.capital;
    }
}

/*

k = 2
w = 0

 0 1 2
[1,2,3]
[0,1,1]
 i




maxprofitheap = [2,1,0]
mincaphead = [1,2]

visited(0)
w = 1

k = 1





*/