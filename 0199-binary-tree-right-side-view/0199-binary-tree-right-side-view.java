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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList();
        if(root == null) return result;
        
        Deque<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        
        while(queue.size() > 0){
            int size = queue.size();
            int rightMost = 0;
            
            for(int i=1; i<=size; i++){
                TreeNode curr = queue.poll();
                rightMost = curr.val;
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            
            result.add(rightMost);
        }
        
        return result;
        
    }
}