class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] seatCounts = new int[n];
        
        for(int[] booking : bookings){
            int f1 = booking[0]-1, f2 = booking[1]-1, seats = booking[2];
            for(int fl = f1; fl <= f2; fl++){
                seatCounts[fl] += seats;
            }
        }

        return seatCounts;
        
    }
}