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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
       List<List<Integer>> result = new ArrayList();
        
        if(root == null) return result;
        
        Deque<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        
        while(queue.size() > 0){
            int size = queue.size();
            List<Integer> level = new ArrayList();
            
            for(int i=1; i<=size; i++){
                TreeNode curr = queue.poll();
                level.add(curr.val);
                
                if(curr.left !=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            
            result.add(0,level);
        }
        
        return result;
        
        
        
        
        
    }
}

/*

queue = [3,9,20,15,7]
count = [1,2,2]



*/