class Solution {
    public int findDuplicate(int[] nums) {
        
        
        int left = 1, right = nums.length;
        int duplicate = -1;
        
        while(left <= right){
            int curr = left + (right-left)/2;
            int count = 0;
            for(int num : nums){
                if(num <= curr) count++;
            }
            if(count > curr){
                duplicate = curr;
                right = curr-1;
            }
            else left = curr+1;
        }
        
        return duplicate;
        
        
        
    }
}


/*


[1,3,4,2,2]
   i
     
cand = 3


sum = 15
sum = 12
      

0001
0011

0010
1000
1010

1010
0010
1000

1000
0010
1010





*/