class Solution {
    public long appealSum(String s) {
        
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        long localAppeal = 0, globalAppeal = 0;
        
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            localAppeal += i - lastSeen[c-'a'];
            lastSeen[c-'a'] = i;
            globalAppeal += localAppeal;
        }
        
        return globalAppeal;
        
        
        
    }
}


/*
01234
abbca
    i

lastseen
a - 0
b - 2
c - 3

score
a - 4
b - 1
c - 4

local = 9
result = 17







*/