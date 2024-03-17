class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        HashMap<Integer, LinkedList<Pair<Integer, Integer>>> adjlist = new HashMap();
        
        for(int[] flight : flights){
            int source = flight[0], dest = flight[1], price = flight[2];
            
            adjlist.computeIfAbsent(source, l -> new LinkedList<Pair<Integer,Integer>>()).add(new Pair<Integer,Integer>(dest, price));
        }
        
        //bfs
        int stops = 0;
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        
        Deque<int[]> queue = new LinkedList();
        queue.offer(new int[]{src, 0});
        
        while(queue.size()>0 && stops <= k){
            int size = queue.size();
            
            for(int i=1; i<=size; i++){
                int[] curr = queue.poll();
                int dist = curr[1];
                int node = curr[0];
                    
                if(!adjlist.containsKey(node)) continue;
                
                for(Pair<Integer,Integer> nextpair : adjlist.get(node)){
                    int nextNode = nextpair.getKey();
                    int price = nextpair.getValue();
                    
                    if(prices[nextNode] > (dist + price)){
                        prices[nextNode] = dist + price;
                        queue.offer(new int[]{nextNode, prices[nextNode]});
                    }
                }
            }
            stops++;
        }
        
        return (prices[dst] == Integer.MAX_VALUE)?-1:prices[dst];
        
        
        
        
        
        
        
    }
}