/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return backtrack(nestedList, 0, 1);
    }
    
    public int backtrack(List<NestedInteger> nestedList, int idx, int depth){
        if(idx == nestedList.size()) return 0;
        
        int result = 0;
        for(int i=idx; i<nestedList.size(); i++){
            NestedInteger nobj = nestedList.get(i);
            
            if(nobj.isInteger()){
                result += nobj.getInteger()*depth;
            }
            else{
                result += backtrack(nobj.getList(), 0, depth+1);
            }
        }
        
        return result;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}