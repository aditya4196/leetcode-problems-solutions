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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList();
        
        if(root == null) return result;
        
        Deque<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        
        int currLevel = 1;
        
        while(queue.size() > 0){
            int size = queue.size();
            List<Integer> level = new LinkedList();

            for(int i=1; i<=size; i++){
                TreeNode curr = queue.poll();

                if(currLevel%2 == 0) level.add(0,curr.val);
                else level.add(curr.val);
                
                if(curr.left !=null) queue.offer(curr.left);
                if(curr.right !=null) queue.offer(curr.right);
            }
            currLevel++;
            
            result.add(level);
        }
        
        return result;       
    }
}