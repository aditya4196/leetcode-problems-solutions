class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0, ones = 0, twos = 0;
        
        for(int num : nums){
            if(num == 0) zeros++;
            else if(num == 1) ones++;
            else twos++;
        }
        
        int i=0;
        while(zeros-- > 0) nums[i++] = 0;
        while(ones-- > 0) nums[i++] = 1;
        while(twos-- > 0) nums[i++] = 2;
        
    }
}

/*

 [2,0,2,1,1,0]
  i
            j





*/