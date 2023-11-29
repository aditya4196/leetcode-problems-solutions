class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        
        int result = 0;
        for(int i=0; i<nums.size(); i++){
            result += (bitCount(i) == k)?nums.get(i):0;
        }
        return result;
        
    }
    
    public int bitCount(int num){
        int count = 0;
        while(num > 0){
            count += num%2;
            num = num/2;
        }
        return count;
    }
}