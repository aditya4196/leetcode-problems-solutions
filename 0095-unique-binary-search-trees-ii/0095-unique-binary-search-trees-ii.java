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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(start > end){
            result.add(null);
            return result;
        }
        
        for(int curr=start; curr<=end; curr++){
            List<TreeNode> leftTrees = helper(start, curr-1);
            List<TreeNode> rightTrees = helper(curr+1, end);
            
            for(TreeNode l : leftTrees){
                for(TreeNode r : rightTrees){
                    TreeNode root = new TreeNode(curr, l, r);
                    result.add(root);
                }
            }
        }            
        return result;
    }
}