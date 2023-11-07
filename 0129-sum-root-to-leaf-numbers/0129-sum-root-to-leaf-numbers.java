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
    int result = 0;
    public int sumNumbers(TreeNode root) {
        traversal(root, 0);
        return result;
    }
    
    public void traversal(TreeNode curr, int sum){
        if(curr == null) return;
        if(curr.left == null && curr.right == null){
         result += sum*10 + curr.val;
         return;
        }
        
        traversal(curr.left, sum*10 + curr.val);
        traversal(curr.right, sum*10 + curr.val);
    }
}