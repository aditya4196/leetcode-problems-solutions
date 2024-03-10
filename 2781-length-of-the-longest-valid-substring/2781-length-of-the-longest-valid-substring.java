class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> set = new HashSet<>(forbidden);
        int i = 0, j = 0, max = 0, n = word.length();
        int end = n-1;
        
        for(i = n-1; i >= 0; i--) {
            for(j = i; j <= end && j < i + 10; j++) {
                String sub = word.substring(i, j + 1);
                // System.out.println("i = " + i + " j = " + j + " sub = " + sub + " end = " + end);
                if(set.contains(sub)) {
                    end = j - 1;
                    break;
                }
            }
            max = Math.max(max, end-i+1);
        }
        
        return max;
    }
}

/*

leetcode
       i
       j

end = n-1

["de","le","e"]
  
set(de,le,e)


*/