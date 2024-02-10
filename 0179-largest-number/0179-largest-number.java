class Solution {
    
    private class StrComparator implements Comparator<String>{
    @Override
    public int compare(String str1, String str2){
        return (str2 + str1).compareTo(str1 + str2);
        }
    }
    
    
    public String largestNumber(int[] nums) {
        
        String[] input = new String[nums.length];
        
        for(int i=0; i<nums.length; i++){
            input[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(input, new StrComparator());
        
        if(input[0].equals("0")) return "0";
        
        String result = "";
        for(String val : input){
            result += val;
        }
        
        return result;
        
        
        
        
    }
    

    
    
}



/*




[987,]




*/