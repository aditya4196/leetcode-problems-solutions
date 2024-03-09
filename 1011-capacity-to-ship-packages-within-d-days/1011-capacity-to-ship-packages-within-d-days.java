class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int sum = 0;
        for(int weight : weights) sum += weight;
        
        int left = 0, right = sum;
        
        while(left < right){
            int mid = left + (right-left)/2;
            if(isPossible(weights, days, mid)){
                right = mid;
            }
            else left = mid+1;
        }
        
        return left;
    }
    
    public boolean isPossible(int[] weights, int days, int capacity){
        int widx = 0;
        for(int i=1; i<=days; i++){
            int tempcap = capacity;
            while(widx < weights.length && (tempcap-weights[widx]) >= 0){
                tempcap -= weights[widx];
                widx++;
            }
            if(widx == weights.length) return true;
        }
        
        return widx == weights.length;  
    }
}

/*

[3,2,2,4,1,4], days = 3
  

1. .........  16
i              j





*/