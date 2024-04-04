class Solution {
    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(heaters);
        Arrays.sort(houses);
        
        int left = 0, right = 1000000001;
        int result = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(isPossible(mid, houses, heaters)){
                result = mid;
                if(result == 2){
                    System.out.println(left);
                    System.out.println(right);
                }
                right = mid-1;
            }
            else left = mid+1;
        }
        
        return result;
    }
    
    public boolean isPossible(int radius, int[] houses, int[] heaters){
        int ptr1 = 0, ptr2 = 0;
        
        while(ptr1 < houses.length && ptr2 < heaters.length){
            int low = heaters[ptr2] - radius, high = heaters[ptr2] + radius;
            while(ptr1 < houses.length && houses[ptr1] >= low && houses[ptr1] <= high){
                ptr1++;
            }
            ptr2++;
        }
        
        return ptr1 == houses.length;
    }
    
    
}

/*
[T,F,T,F,F,T]
[F,T,F,F,F,T]

[2]
 j

[1,5]
 j     
            r


[1,4] [1,7]

*/