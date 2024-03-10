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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList();
        if(root == null) return result;
        
        TreeNode curr = root;
        Stack<Pair<TreeNode,Boolean>> stack = new Stack();
        stack.push(new Pair(curr, false));
        
        while(!stack.isEmpty()){
            Pair<TreeNode, Boolean> currPair = stack.pop();
            
            TreeNode node = currPair.getKey();
            Boolean visited = currPair.getValue();
            
            if(visited){
                result.add(node.val);
            }
            else{
                stack.push(new Pair<>(node, true));
                if(node.right!=null) stack.push(new Pair<>(node.right, false));
                if(node.left!=null) stack.push(new Pair<>(node.left, false));
            }
            
        
        }
        
        return result;
        
        
    }
}