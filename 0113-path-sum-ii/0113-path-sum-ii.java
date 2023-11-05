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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList();
        if(root == null) return output;
        
        pathSum(root, targetSum, new ArrayList<Integer>(), output);

        return output;
    }
    
    public void pathSum(TreeNode curr, int sum, List<Integer> arr, List<List<Integer>> output){
        if(curr == null){
            return;
        }
        
        arr.add(curr.val);
        
        if(curr.left == null && curr.right == null && sum == curr.val){
            output.add(new ArrayList<Integer>(arr));
        }
        
        else{
            pathSum(curr.left, sum-curr.val, arr, output);
            pathSum(curr.right, sum-curr.val, arr, output);
         }
        
        arr.remove(arr.size()-1);
    }
    
}