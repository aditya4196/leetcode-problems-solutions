class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        
        int start = 0, end=0;
        List<List<Integer>> result = new ArrayList();
        
        if(s.length() == 1) return result;
        for(end=0; end<s.length()-1; end++){
                if(s.charAt(end) != s.charAt(end+1)){
                    if(end-start+1 >= 3){
                        result.add(Arrays.asList(start,end));
                    }
                    start = end+1;
                }
        }

        if(s.charAt(end-1) == s.charAt(end) && (end-start+1) >= 3){
            result.add(Arrays.asList(start,end));
        }
    return result;    
        
    }
}

/*


a b b x x x x z z y
e
s


*/