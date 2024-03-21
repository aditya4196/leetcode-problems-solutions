class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int start = 0;
        int lastCharPtr = 0;
        List<Integer> result = new ArrayList();
        
        int[] lastIndex = new int[26];
        for(int i=0; i<n; i++){
            lastIndex[s.charAt(i)-'a'] = i;
        }
        
        for(int end=0; end<n; end++){
            lastCharPtr = Math.max(lastCharPtr, lastIndex[s.charAt(end)-'a']);
            if(end == lastCharPtr){
                result.add(end-start+1);
                start = end+1;
            }
        }
        
        return result;
    }
}

/*

ababcbacadefegdehijhklij
     i
a
*/