class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        List<Boolean> result = new ArrayList<Boolean>();
        
        for(int i=0; i<l.length; i++){
            int[] tempArr = Arrays.copyOfRange(nums, l[i], r[i]+1);
            Arrays.sort(tempArr);
            
            int diff = 0;
            boolean valid = true;
            for(int j=0; j<tempArr.length-1; j++){
                if(j > 0 && (tempArr[j+1] - tempArr[j]) != diff){
                    valid = false;
                    break;
                }
                else{
                    diff = tempArr[j+1] - tempArr[j];
                }
            }
            if(valid) result.add(true);
            else result.add(false);
        }
        
        return result;
        
    }
}

/*

1, 3, 5, 7, 9


*/