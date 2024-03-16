class Solution {
    public int minOperations(int[] nums) {
        
        Map<Integer, Integer> countMap = new HashMap();
        for(int num : nums) countMap.put(num, countMap.getOrDefault(num,0)+1);
        int result = 0;
        
        for(int count : countMap.values()){
            
            if(count%3 == 0) result += count/3;
            else{
                while(count%3 != 0 && count > 1){
                    count -= 2;
                    result += 1;
                }
                if(count == 1) return -1;
                
                result += (count/3);
            }
        }
        
        return result;
        
        
        
    }
}

/*

[2,3,3,2,2,4,2,3,4]

2 - 4
3 - 3
4 - 2






*/