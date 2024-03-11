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
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return true;
        
        TreeNode p = root;
        TreeNode q = root;
      
        
        Stack<Pair<TreeNode, TreeNode>> stack = new Stack();
        stack.push(new Pair(p,q));
        
        while(!stack.isEmpty()){
            Pair<TreeNode, TreeNode> pair = stack.pop();
            p = pair.getKey();
            q = pair.getValue();
            
            if(p != null){
                if((q == null) || p.val != q.val) return false;
            }
            
            if(q != null){
                if((p == null) || p.val != q.val) return false;
            }
            
            if(p == null && q == null) continue;
            
            stack.push(new Pair<TreeNode, TreeNode>(p.left, q.right));
            stack.push(new Pair<TreeNode, TreeNode>(p.right, q.left));
        }
        
        return true;
        
        
        
        
    }
}