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
    HashMap<TreeNode, TreeNode> parentMap = new HashMap();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        storeParentMap(root);

        Queue<Pair<TreeNode, Integer>> bfsq = new LinkedList();
        List<Integer> output = new ArrayList();
        Set<Integer> visited = new HashSet();
        //visited.add(target.val);

        bfsq.offer(new Pair(target, 0));

        while(bfsq.size() > 0){
            int size = bfsq.size();
            for(int i=1; i<=size; i++){
                Pair<TreeNode, Integer> currPair = bfsq.poll();
                int distance = currPair.getValue();
                TreeNode curr = currPair.getKey();
                visited.add(curr.val);
                if(distance == k){
                    output.add(curr.val);  
                    continue;
                }
                

                if(curr.left!=null && !visited.contains(curr.left.val)){
                    bfsq.offer(new Pair<TreeNode, Integer>(curr.left,distance+1));
                    //visited.add(curr.left.val);
                }

                if(curr.right!=null && !visited.contains(curr.right.val)){
                    bfsq.offer(new Pair<TreeNode, Integer>(curr.right,distance+1));
                }

                TreeNode parent = parentMap.get(curr);
                if(parent!=null && !visited.contains(parent.val)){
                    bfsq.offer(new Pair<TreeNode, Integer>(parent,distance+1));
                }
            }
        }


        return output;


    }

    public void storeParentMap(TreeNode root){
        if(root == null) return;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while(queue.size() > 0){
            int size = queue.size();
            for(int i=1; i<=size; i++){
                TreeNode curr = queue.poll();
                if(curr.left!=null){
                    parentMap.put(curr.left, curr);
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    parentMap.put(curr.right, curr);
                    queue.offer(curr.right);
                }
            }
        }
    }
} 