class Solution {
    List<String> result = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return result;
        Map<Character, String> digitsMap = new HashMap();
        digitsMap.put('2',"abc");
        digitsMap.put('3',"def");
        digitsMap.put('4',"ghi");
        digitsMap.put('5',"jkl");
        digitsMap.put('6',"mno");
        digitsMap.put('7',"pqrs");
        digitsMap.put('8',"tuv");
        digitsMap.put('9',"wxyz");
        
        backtrack(digits, 0, digitsMap, new StringBuilder());
        return result;
    }
    
    public void backtrack(String digits, int idx, Map<Character, String> map, StringBuilder inter){
        if(inter.length() == digits.length()){
            result.add(inter.toString());
            return;
        }
        
        for(int i=0; i<map.get(digits.charAt(idx)).length(); i++){
            inter.append(map.get(digits.charAt(idx)).charAt(i));
            backtrack(digits, idx+1, map, inter);
            inter.deleteCharAt(inter.length()-1);
        }
    }
}