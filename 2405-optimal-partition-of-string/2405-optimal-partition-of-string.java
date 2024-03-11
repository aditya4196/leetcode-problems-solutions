class Solution {
    public int partitionString(String s) {
        
        Set<Character> set = new HashSet();
        int count = 0;
        
        for(int j=0; j<s.length(); j++){
            if(set.contains(s.charAt(j))){
                count++;
                set.clear();
            }
            set.add(s.charAt(j));
        }
        
        return (set.size() > 0)?(count+1):count;
        
    }
}

/*

a - 6
b - 5
c - 3



0123456
abacaba
i
j

*/