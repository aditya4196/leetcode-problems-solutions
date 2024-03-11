class Solution {
    public long countVowels(String word) {
        int n = word.length();
        long result = 0;
        
        for(int i=0; i<n; i++){
            char c = word.charAt(i);
            
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                result += ((long)(i+1) * (n-i));
            }
        }
        
        return result;
        
    }
}



/*
012
aba
 i

vowelcount = 4
substring count = 2


b -> -1, 1, 3
a -> -1, 0, 2

running = count = 1




a - 1
ab - 1
aba - 2
ba - 1
a - 1
b - 0


*/