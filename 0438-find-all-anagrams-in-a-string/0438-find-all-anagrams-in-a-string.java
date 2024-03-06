class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        if(s.length() < p.length()) return new ArrayList<Integer>();
        int[] smap = new int[26];
        int[] pmap = new int[26];
        
        for(char c : p.toCharArray()) pmap[c-'a']++;
        for(int i=0; i<p.length(); i++){
            smap[s.charAt(i) - 'a']++;
        }
        
        List<Integer> result = new ArrayList();
        if(matches(smap, pmap)) result.add(0);
        
        for(int j=p.length(); j<s.length(); j++){
            smap[s.charAt(j)-'a']++;
            smap[s.charAt(j-p.length()) - 'a']--;
            if(matches(smap, pmap)) result.add(j-p.length()+1);
        }
        
        return result;
        
    }
    
    public boolean matches(int[] smap, int[] pmap){
        for(int i=0; i<26; i++){
            if(smap[i] != pmap[i]) return false;
        }
        return true;
    }
}


/*

cbaebabacd
 i j

smap :-
a - 1
b - 1
c - 0
e - 1

pmap :-
a - 1
b - 1
c - 1




*/