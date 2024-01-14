class Solution {
    public int minDeletionSize(String[] strs) {
        if(strs.length == 0) return 0;
        
        int rowlen = strs[0].length();
        int collen = strs.length;
        
        int delCount = 0;
        for(int i=0; i<rowlen; i++){
            StringBuilder temp = new StringBuilder();

            for(int j=0; j<collen; j++){
                temp.append(strs[j].charAt(i));
            }
            char[] arr = temp.toString().toCharArray();
            Arrays.sort(arr);
            
            if(!temp.toString().equals(String.valueOf(arr))){
                delCount++;
            }
        }
        
        return delCount;
        
        
    }
}

/*

c d g
b a h
a f i



*/