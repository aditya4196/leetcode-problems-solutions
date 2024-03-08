class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long right = Integer.MIN_VALUE;
        for(int pile : piles){
            right = Math.max(right, pile);
        }
        long left = 1;
        
        while(left < right){
            long mid = left + (right-left)/2;   
            if(isRemaining(piles, h, mid)){
                right = mid;
            } 
            else left = mid+1;
        }
        
        return (int)left;
    }
    
    public boolean isRemaining(int[] piles, int h, long k){

        int hoursLeft = h;
        for(int pile : piles){
            if(pile < k){
                hoursLeft -= 1;
            }
            else hoursLeft -= Math.ceil((double)pile/k);
        }
        
        return hoursLeft >= 0;
    }
    
    
}

/*


[3,6,7,11], h = 8
 
 cand = 6
 
 11/6

1,2,3,4,5,6,7,8,9,10,11
          m   
l
                     r





*/