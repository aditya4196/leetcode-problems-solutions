class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        Map<Integer, Integer> countMap1 = new TreeMap();
        Map<Integer, Integer> countMap2 = new TreeMap();
        Set<Character> set = new HashSet();
        
        int[] freq = new int[26];
        for(char c : word1.toCharArray()){
            set.add(c);
            freq[c-'a']++;
        }
        
        for(int i=0; i<26; i++)countMap1.put(freq[i], countMap1.getOrDefault(freq[i],0)+1);
        
        freq = new int[26];
        for(char c : word2.toCharArray()){
            if(!set.contains(c)) return false;
            freq[c-'a']++;
        }
        
        for(int i=0; i<26; i++) countMap2.put(freq[i], countMap2.getOrDefault(freq[i],0)+1);
        
        for(int val : countMap1.keySet()){
            if(val == 0) continue;
            if(countMap1.get(val) != countMap2.get(val)) return false;
        }
        
        return true;
        
        
        
        
        
        
        
        
        
        
        
    }
}

/*

cabbba
c-1
b-3
a-2

abbccc
a-1
c-3
b-2



*/