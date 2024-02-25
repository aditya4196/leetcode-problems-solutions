class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int visitedRooms = rooms.size();
        boolean[] keys = new boolean[rooms.size()];
        Deque<Integer> queue = new ArrayDeque<Integer>();
        keys[0] = true;
        queue.offer(0);

        while(queue.size() > 0){
            int size = queue.size();
            for(int i=1; i<=size; i++){
                int currRoom = queue.poll();
                visitedRooms--;

                for(int nextRoom : rooms.get(currRoom)){
                    if(keys[nextRoom]) continue;
                    keys[nextRoom] = true;
                    queue.offer(nextRoom);
                }
            }
        }

        return visitedRooms == 0;

    }
}