class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> formed = new HashSet();
        
        while(n > 1){
            int temp = n;
            int sum = 0;
            
            while(temp > 0){
                sum += (temp%10)*(temp%10);
                temp/=10;
            }
            
            if(formed.contains(sum)) return false;
            formed.add(sum);
            n = sum;
        }
        
        return n == 1;
        
        
    }
}