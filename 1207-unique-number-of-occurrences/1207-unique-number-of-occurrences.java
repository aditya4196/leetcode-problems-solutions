class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int k = 1000;
        int[] freq = new int[2*k+1];
        
        for(int val : arr){
            freq[val+k]++;
        }
        
        Arrays.sort(freq);
        
        for(int i=0; i<freq.length; i++){
            if(i>0 && freq[i]!=0 && freq[i] == freq[i-1]) return false;
        }
        return true;
        
    }
}