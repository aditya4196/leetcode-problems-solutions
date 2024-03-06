class Solution {
    public int totalFruit(int[] fruits) {
        
        int[] typeCount = new int[100001];
        int start = 0, maxFruits = 0, count = 0;
        
        
        for(int end=0; end<fruits.length; end++){
            if(typeCount[fruits[end]]++ == 0) count++;
            
            while(count > 2){
                if(typeCount[fruits[start]]-- == 1) count--;
                start++;
            }
            
            maxFruits = Math.max(maxFruits, end-start+1);
        }
        
        return maxFruits;
        
        
        
    }
}