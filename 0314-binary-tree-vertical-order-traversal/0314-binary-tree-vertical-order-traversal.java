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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        
        Map<Integer, ArrayList<Integer>> verticalMap = new TreeMap<Integer, ArrayList<Integer>>();
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
        queue.offer(new Pair<>(root, 0));

        verticalMap.computeIfAbsent(0, k -> new ArrayList<Integer>()).add(root.val);
        

        while(queue.size() > 0){
            int size = queue.size();
            
            for(int i=1; i<=size; i++){
                Pair<TreeNode, Integer> pair = queue.poll();
                
                TreeNode curr = pair.getKey();
                int idx = pair.getValue();
                
                if(curr.left!=null){

                    verticalMap.computeIfAbsent(idx-1, k -> new ArrayList<Integer>()).add(curr.left.val);
                    queue.offer(new Pair<>(curr.left, idx-1));
                }
                if(curr.right!=null){
                    verticalMap.computeIfAbsent(idx+1, k -> new ArrayList<Integer>()).add(curr.right.val); 
                    queue.offer(new Pair<>(curr.right, idx+1));
                } 
            }
        }
        
        result.addAll(verticalMap.values());
        return result;
        
        
        
    }
}