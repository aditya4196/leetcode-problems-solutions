class Solution {
    public String discountPrices(String sentence, int discount) {
        if(sentence.equals("")) return sentence;
        
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        int n = words.length;
        
        for(int i=0; i<n; i++){
            String word = words[i];
            
            if(word.length() <= 1 || word.charAt(0) != '$'){
                result.append(word);
                if(i < n-1) result.append(" ");
            }
            else{
            
                double num2 = 0.00;

                String subword = word.substring(1, word.length());
                if(!isValid(subword)){
                    result.append(word);
                    if(i < n-1) result.append(" ");
                }
                else{
                    num2 = Double.parseDouble(word.substring(1, word.length()));
                    double discountedPrice = num2*((double)discount/100);
                    num2 -= discountedPrice;  
                    
                    String price = String.format("%.2f", num2);
                    
                    String newWord = "$" + price;
                    result.append(newWord);
                    if(i < n-1) result.append(" ");   
                 }   
               }
            }
        
            return result.toString();
            
        }

            
        public boolean isValid(String num){
            for(int i=0; i<num.length(); i++){
                if(!Character.isDigit(num.charAt(i))) return false;
            }
            return true;
         
        }
        
        
    }

/*





*/