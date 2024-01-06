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
        Map<Integer, List<Integer>> colmap = new TreeMap();
        Deque<Nodepair> queue = new LinkedList();
        queue.offer(new Nodepair(root, 0));
        
        while(queue.size() > 0){
            Nodepair np = queue.poll();
            if(np.node == null) continue;
            colmap.computeIfAbsent(np.idx, k -> new ArrayList<Integer>()).add(np.node.val);
            queue.offer(new Nodepair(np.node.left, np.idx-1));
            queue.offer(new Nodepair(np.node.right, np.idx+1));
        }
    
        List<List<Integer>> result = new ArrayList();
        for(List<Integer> list : colmap.values()){
            result.add(list);
        }
        
        return result;
    }   
    
}

class Nodepair{
    TreeNode node;
    int idx;
    
    public Nodepair(TreeNode node, int idx){
        this.idx = idx;
        this.node = node;
    }
}