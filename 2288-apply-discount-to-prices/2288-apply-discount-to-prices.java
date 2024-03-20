class Solution {
    public String discountPrices(String sentence, int discount) {
        
        String[] words = sentence.split(" ");
        boolean validNumber = false;
        StringBuilder result = new StringBuilder();
        int n = words.length;
        
        for(int i=0; i<n; i++){
            validNumber = true;
            String word = words[i];
            
            if(word.charAt(0) != '$'){
                result.append(word);
                if(i < (n-1)) result.append(" ");
            }
            else{
                if(word.length() == 1){
                    result.append(word);
                    if(i < (n-1)) result.append(" ");
                    continue;
                }
                
                long num = 0;
                
                
                for(int j=1; j<word.length(); j++){
                    if(!Character.isDigit(word.charAt(j))){
                        validNumber = false;
                        break;
                    }
                    num = num*10 + (word.charAt(j)-'0');
                }
                if(validNumber){
                    long val1 = num*discount;
                    double discountedValue = (double)val1/100;
                    double discountedPrice = num - discountedValue;
                    result.append("$");
                    result.append(String.format("%.2f",discountedPrice));
                    if(i < (n-1)) result.append(" ");
                }
                else{
                    result.append(word);
                    if(i < (n-1)) result.append(" ");
                }
            }
            
        }
        
        return result.toString();
    }
}



/*
are words equally spaced
trailing or leading spaces
the digits preceeded by $, will there be decimal values as well
*/