class Solution {
    
    private int totalRoomsVisited;
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        dfs(rooms, 0, new HashSet<Integer>());
        return getTotalRooms() == rooms.size();
    }
    
    public void dfs(List<List<Integer>> rooms, int currRoom, HashSet<Integer> visited){
        visited.add(currRoom);
        incrTotalRooms();
        
        for(int nextRoom : rooms.get(currRoom)){
            if(!visited.contains(nextRoom)) dfs(rooms, nextRoom, visited);
        }
    }
    
    public void incrTotalRooms(){
        totalRoomsVisited+=1;
    }
    public int getTotalRooms(){
        return totalRoomsVisited;
    }
}