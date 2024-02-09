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

        if(root == null) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList();
        Deque<TreeNode> queue = new LinkedList();

        int level = 0;
        queue.offer(root);
        
        int rightVal = root.val;
        
        while(queue.size() > 0){
            int size = queue.size();
            while(size-- > 0){
                TreeNode curr = queue.poll();
                rightVal = curr.val;
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            result.add(rightVal);
        }

        return result;


        
    }
}