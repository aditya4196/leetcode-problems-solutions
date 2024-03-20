class Solution {
    public String maximumNumber(String num, int[] change) {
        
        int start = 0;
        StringBuilder str = new StringBuilder(num);
        boolean updated = false;
        
        for(int i=0; i<num.length(); i++){
            
            int currInteger = num.charAt(i) - '0';
            int changedInteger = change[num.charAt(i) - '0'];

            if(currInteger <= changedInteger){
                if(currInteger != changedInteger) updated = true;
                String temp = String.valueOf(changedInteger);
                str.setCharAt(i, temp.charAt(0));
            }
            else{
                if(updated) break;
            }
            
        }
        
        return str.toString();
        
    }
}

/*

 9 2 1
   i
   j



maxInteger = 9


*/