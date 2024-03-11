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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<TreeNode, TreeNode> parentMap = new HashMap();
        
        //capture the parentMap
        dfs(root, parentMap);
        
        List<Integer> result = new ArrayList();
        
        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque();
        queue.offer(new Pair<>(target, 0));
        
        Set<Integer> visited = new HashSet();
        
        while(queue.size() > 0){
            int size = queue.size();
            
            for(int i=1; i<=size; i++){
                Pair<TreeNode, Integer> pair = queue.poll();
                
                TreeNode node = pair.getKey();
                int dist = pair.getValue();
                
                visited.add(node.val);
                
                if(dist == k) result.add(node.val);
                else{
                    if(node.left != null && !visited.contains(node.left.val)){
                        queue.offer(new Pair<>(node.left, dist+1));
                    }
                    if(node.right != null && !visited.contains(node.right.val)){
                        queue.offer(new Pair<>(node.right, dist+1));   
                    }
                    if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node).val)){
                        queue.offer(new Pair<>(parentMap.get(node), dist+1));  
                    }
               }
           }
        }
        
        return result;
    }
    
    public void dfs(TreeNode root, Map<TreeNode, TreeNode> parentMap){
        if(root == null) return;
        
        if(root.left!=null) parentMap.put(root.left, root);
        if(root.right!=null) parentMap.put(root.right, root);
        
        dfs(root.left, parentMap);
        dfs(root.right, parentMap);
    
    }
}