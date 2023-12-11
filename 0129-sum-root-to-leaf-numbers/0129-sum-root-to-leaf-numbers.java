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
    public int sumNumbers(TreeNode root) {
        return traversal(root, 0);
    }
    
    public int traversal(TreeNode curr, int sum){
        if(curr == null) return 0;
        
        if(curr.left == null && curr.right == null){
         return sum*10 + curr.val;
        }
        
        return traversal(curr.left, sum*10 + curr.val) + traversal(curr.right, sum*10 + curr.val);
    }
}