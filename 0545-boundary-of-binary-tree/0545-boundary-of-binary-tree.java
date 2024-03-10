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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        List<Integer> result = new ArrayList();
        result.add(root.val);
        
        result.addAll(getLeftBoundary(root.left));
        result.addAll(getLeaves(root, root));
        result.addAll(getRightBoundary(root.right));

     
        return result;
    }
    
    public List<Integer> getLeaves(TreeNode curr, TreeNode root){
        List<Integer> leavesBoundary = new LinkedList();
        
        Stack<TreeNode> stack = new Stack();
        stack.push(curr);
        
        while(!stack.isEmpty()){
            curr = stack.pop();
            
            if(curr != root && curr.left == null && curr.right == null){
                leavesBoundary.add(0,curr.val);
            }
            if(curr.left !=null) stack.push(curr.left);
            if(curr.right !=null) stack.push(curr.right);
        }
        
        return leavesBoundary;
        
    }
    
    public List<Integer> getLeftBoundary(TreeNode curr){
        List<Integer> leftBoundary = new LinkedList();
        
        while(curr!=null){
            if(curr.left !=null || curr.right!=null){
                leftBoundary.add(curr.val);        
            }
            
            if(curr.left != null) curr = curr.left;
            else if(curr.right !=null) curr = curr.right;
            else break;
        }
        
        return leftBoundary;
    }
    
    
    public List<Integer> getRightBoundary(TreeNode curr){
        List<Integer> rightBoundary = new LinkedList();
        
        while(curr!=null){
            if(curr.right!=null || curr.left !=null){
                rightBoundary.add(0,curr.val);        
            }
            
            if(curr.right != null) curr = curr.right;
            else if(curr.left !=null) curr = curr.left;
            else break;
        }
        
        return rightBoundary;
    }
}