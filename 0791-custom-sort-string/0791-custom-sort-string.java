class Solution {
    public String customSortString(String order, String s) {
        
        HashMap<Character, Integer> input = new HashMap();
        for(char c : s.toCharArray()){
            input.put(c, input.getOrDefault(c,0)+1);
        }
        
        char[] priority = order.toCharArray();
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<priority.length; i++){
            char c = priority[i];
            if(input.containsKey(c)){
                int times = input.get(c);
                for(int j=1; j<=times; j++) result.append(c);
                input.remove(c);
            }

        }
        

        
        for(char c : input.keySet()){
            if(input.containsKey(c)){
                int times = input.get(c);
                for(int j=1; j<=times; j++) result.append(c);
                
            }
        }
        
        
        
        
        return result.toString();
    }
}


/*

0 - c
1 - b
2 - c






*/