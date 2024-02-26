class Solution {
    public void reverseWords(char[] s) {
        int n = s.length;
        reverse(s, 0, n-1);
        int start = -1;
        
        for(int i=0; i<s.length; i++){
            if(s[i] == ' '){
                reverse(s, start+1, i-1);
                start = i;
            }
        }
        
        reverse(s, start+1, n-1);
        
        
    
        
    }
    
    public void reverse(char[] s, int i, int j){
        while(i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}

/*

["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
[" ","s","i"," ","y","k","s"," ","e","h","t","e","u","l","b"]                                                       
  
[1,2,3,4,5,6,7,8]
[5,4,3,2,1,8,7,6]

[6,7,8,1,2,3,4,5]



temp = 't'
*/
