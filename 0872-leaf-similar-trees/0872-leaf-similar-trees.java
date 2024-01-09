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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList();
        List<Integer> seq2 = new ArrayList();
        generateLeafSequence(root1, seq1);
        generateLeafSequence(root2, seq2);
        
        if(seq1.size() != seq2.size()) return false;
        for(int i=0; i<seq1.size(); i++){
            if(seq1.get(i) != seq2.get(i)) return false;
        }
        return true;
        
        
    }
    
    public void generateLeafSequence(TreeNode root, List<Integer> seq){
        if(root == null) return;
        if(root.left == null && root.right == null) seq.add(root.val);
        if(root.left!=null) generateLeafSequence(root.left, seq);
        if(root.right!=null) generateLeafSequence(root.right, seq);
    }
}