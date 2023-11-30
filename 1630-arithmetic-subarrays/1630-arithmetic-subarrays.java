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
                else diff = tempArr[j+1] - tempArr[j];
            }
            if(valid) result.add(true);
            else result.add(false);
        }
        
        return result;
        
    }
}

/*

complexity = O(queriescount * n * log(n))

0  1. 2. 3. 4. 5
4, 6, 5, 9, 3, 7

2  1. 4. 6. 4. 0

l = [0,0,2], 
r = [2,3,5]

result [true,false,true]
*/