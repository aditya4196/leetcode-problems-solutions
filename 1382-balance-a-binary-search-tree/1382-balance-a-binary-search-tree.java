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
    
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorderlist = new ArrayList();
        inorder(root, inorderlist);
        return createTree(inorderlist, 0, inorderlist.size()-1);        
    }
    
    public TreeNode createTree(List<Integer> list, int low, int high){
        if(low > high) return null;
        int mid = low + (high-low)/2;
        
        TreeNode newnode = new TreeNode(list.get(mid));
        newnode.left = createTree(list, low, mid-1);
        newnode.right = createTree(list, mid+1, high);
        return newnode;
    }
    
    public void inorder(TreeNode curr, List<Integer> inorderlist){
        if(curr == null) return;
        inorder(curr.left, inorderlist);
        inorderlist.add(curr.val);
        inorder(curr.right, inorderlist);
    } 
    
    
}