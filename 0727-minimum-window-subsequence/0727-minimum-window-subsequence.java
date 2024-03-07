class Solution {
    public String minWindow(String s1, String s2) {
        
        String minString = "";
        int minLength = Integer.MAX_VALUE;
        
        List<Integer> indices = new ArrayList();
        char first = s2.charAt(0);
        
        for(int i=0; i<s1.length(); i++){
            if(first == s1.charAt(i)) indices.add(i);
        }
        
        
        for(int index : indices){
            boolean found = false;
            
            int k = 0;
            for(int i=index; i<s1.length(); i++){
                if(s1.charAt(i) == s2.charAt(k)){
                    k++;
                }
                
                if(k == s2.length()){
                    if(minLength > (i-index+1)){
                        minString = s1.substring(index, i+1);
                        minLength = i-index+1;
                    }
                    break;
                }
            }
        }
        
        return minString;
        
    }
}

/*

01234567
abcdebde
   j  
 i
 
b = [1,5]
 
bde
 k



*/