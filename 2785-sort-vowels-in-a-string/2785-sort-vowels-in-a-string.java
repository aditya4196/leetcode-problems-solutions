class Solution {
    public String sortVowels(String s) {
        String vowels= ""; 
        if(s=="") return "";
        for(int i=0;i<s.length();i++){
            if("AEIOUaeiou".indexOf(s.charAt(i)) >= 0){
                vowels=vowels+s.charAt(i);
            }
        }

        char[] original = s.toCharArray();
        char[] v =vowels.toCharArray();
        Arrays.sort(v);
        int k=0;
        for(int i=0;i<s.length();i++){
            if("AEIOUaeiou".indexOf(s.charAt(i)) >= 0){
                original[i]=v[k];
                k++;
            }
        }

         String ansString = new String(original);
        return ansString;
        
    }
}