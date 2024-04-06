/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int result;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        result = 0;
        Set<Integer> set = new HashSet<Integer>();
        helper(root, set);
        return result;
        
    }
    
    public void helper(TreeNode curr, Set<Integer> set){
        if(curr == null) return;
        
        if(set.contains(curr.val)) set.remove(curr.val);
        else set.add(curr.val);
        
        if(curr.left == null && curr.right == null)
        {
            if(set.size() <= 1) result += 1;
        }
        
        helper(curr.left, new HashSet<Integer>(set));
        helper(curr.right, new HashSet<Integer>(set));
    }
}