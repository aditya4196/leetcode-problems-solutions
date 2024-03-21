class Solution {
    public String convert(String s, int numRows) {

        if(s.length() == 1 || numRows == 1) return s;
        //define no of cols
        int n = numRows;
        int diff = 2*(n-2) + 1;
        int ncols = 0;
        int i=0;
        for(i=0; i<s.length(); i++){
            i+=diff;  
        }
        ncols = i;

        char[][] resultMatrix = new char[numRows][ncols];
        for(i=0; i<numRows; i++){
            Arrays.fill(resultMatrix[i],'*');
        }
        
        //traverse the chars and fill them in matrix in zigzag
        
        int sptr = 0, rowptr = 0, colptr = 0;
        
        while(sptr < s.length() && colptr < ncols){
           if(rowptr < (numRows-1)){
               resultMatrix[rowptr][colptr] = s.charAt(sptr);
               rowptr++;
               sptr++;
           } 
           else{
               while(sptr < s.length() && rowptr > 0){
                   resultMatrix[rowptr][colptr] = s.charAt(sptr);
                   rowptr -= 1;
                   colptr += 1;
                   sptr += 1;
               }
           }
        }
        

        
        int countchars = 0;
        StringBuilder result = new StringBuilder();
        for(rowptr = 0; rowptr < numRows; rowptr++){
            for(colptr = 0; colptr < ncols; colptr++){
                if(resultMatrix[rowptr][colptr] != '*'){
                    result.append(resultMatrix[rowptr][colptr]);
                    if(++countchars == s.length()) return result.toString();
                    
                }
            }
        }
        
        return result.toString();
       

        
    }
}

/*

012345678910111213
PAYPALISHI R I N G

P     I    N
A   L S  I G
Y A   H R
P     I

n = 3
row = 3
diff = 3
visited = [0,4,8,12,1,3]         
result = PAHNAPLSIG



*/