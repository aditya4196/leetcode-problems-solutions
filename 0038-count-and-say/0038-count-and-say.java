class Solution {
    public String countAndSay(int n) {
        
        if(n == 1) return "1";
        
        int count;
        char currDigit;
        String input = "1";
     
        for(int i=1; i<n; i++){    
            count = 1;
            currDigit = input.charAt(0);
            StringBuilder nextSequence = new StringBuilder();
            
            for(int j=1; j<input.length(); j++){
                if(input.charAt(j) == currDigit){
                    count++;
                }  
                else{
                    nextSequence.append(String.valueOf(count));
                    nextSequence.append(currDigit);
                    count = 1;
                    currDigit = input.charAt(j);
                }
            }
            nextSequence.append(String.valueOf(count));
            nextSequence.append(currDigit);
            input = nextSequence.toString();
        }
        
        return input.toString();
        
        
    }
}

// "3322251"
    
// "23321511"
    
// n = 4
    
// n = "1"
    
// "11"
//     i
 
//  count = 2
//  currDigit = 1
//  newString = "2" + currDigit    
     
    
    
//     "21"
//     "1211"
    