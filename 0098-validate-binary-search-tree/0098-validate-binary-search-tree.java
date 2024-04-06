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
    public boolean isValidBST(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack();
        TreeNode prev = null;
        TreeNode curr = root;
        
        while(!stack.isEmpty() || curr!=null){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            if(prev != null && curr.val <= prev.val) return false;
            prev = curr;
            curr = curr.right;
        }
        
        return true;
        
    }
}

/*

                5
            1.     4
                3.    6




*/