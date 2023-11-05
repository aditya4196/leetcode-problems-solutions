/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = new HashMap();
        Deque<TreeNode> queue = new LinkedList();
        
        queue.offer(root);
        parentMap.put(root, null);
        
        while(queue.size() > 0){
            int size = queue.size();
            for(int i=1; i<=size; i++){
                TreeNode node = queue.poll();
                
                if(node.left!=null){
                    parentMap.put(node.left, node);
                    queue.offer(node.left);
                }

                if(node.right!=null){
                    parentMap.put(node.right, node);
                    queue.offer(node.right);
                }
            }
        }
        
        Set<TreeNode> ancestors = new HashSet();
        
        TreeNode pnode = p;
        while(pnode != null){
            ancestors.add(pnode);
            pnode = parentMap.get(pnode);
        }
        
        pnode = q;
        while(pnode != null){
            if(ancestors.contains(pnode)) return pnode;
            pnode = parentMap.get(pnode);
        }
        
        return null;
        
        
    }
}