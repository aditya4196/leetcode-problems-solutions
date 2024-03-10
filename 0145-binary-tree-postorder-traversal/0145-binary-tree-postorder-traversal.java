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
        
        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();
        stack1.push(curr);
        
        while(!stack1.isEmpty()){
            curr = stack1.pop();
            stack2.push(curr);
            
            if(curr.left!=null) stack1.push(curr.left);
            if(curr.right!=null) stack1.push(curr.right);
        }
        
        while(!stack2.isEmpty()){
            result.add(stack2.pop().val);
        }
        
        return result;
        
        
        
        
    }
}

/*


 stack = [3]
 stack2 = [1,2]



*/