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
    int preorderindex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inorderMap = new HashMap();
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i],i);
        }
        
        return buildTree(preorder, inorderMap, 0, preorder.length-1);
    }
    
    public TreeNode buildTree(int[] preorder, HashMap<Integer,Integer> map, int left, int right){
        if(left > right) return null;
        
        int currValue = preorder[preorderindex++];
        TreeNode currNode = new TreeNode(currValue);
        
        currNode.left = buildTree(preorder, map, left, map.get(currValue)-1);
        currNode.right = buildTree(preorder, map, map.get(currValue)+1, right);
        
        return currNode;
        
    }

}








