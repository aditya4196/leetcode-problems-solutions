class Solution {
    List<String> result;
    Set<String> wordSet;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<String>();
        wordSet = new HashSet<String>(wordDict);
        helper(s, 0, new String());    
        return result;
    }
    
    public void helper(String s, int idx, String suboutput){
        if(idx >= s.length()){
            System.out.println(suboutput);
            if(suboutput.length()>0){
                result.add(new String(suboutput));
            }
            return;
        }
        
        for(int i=idx; i<s.length(); i++){
            String subword = s.substring(idx,i+1);
            if(wordSet.contains(subword)){
                helper(s, i+1, suboutput + ((suboutput.length() == 0)?subword:" "+subword));
            }
        }
    }
}



/*
["cat","cats","and","sand","dog"]

                                catsanddog
 
                                    ()
                                    
    (c) (ca) (cat)           ()(cats)     (catsa)      (catsan)      (catsand)
                           
                   (cats )(a)   (cats )(and) 
          
                                    (cats and )()
                            
                        












*/