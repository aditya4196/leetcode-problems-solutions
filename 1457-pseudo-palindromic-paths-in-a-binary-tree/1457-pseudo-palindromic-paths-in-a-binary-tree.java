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
    public int pseudoPalindromicPaths (TreeNode root) {
        return traverse(root, new int[10]);
    }
    
    public int traverse(TreeNode root, int[] freq){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
           freq[root.val]++;
           int count = checkPalindrome(freq)?1:0;
           freq[root.val]--;
           return count;
        }
        
        freq[root.val]++;
        int count = traverse(root.left, freq) + traverse(root.right, freq);
        freq[root.val]--;
        return count;
    }
    
    public boolean checkPalindrome(int[] freq){
        int oddCount = 0;
        for(int i=1; i<=9; i++){
            if(freq[i]%2 != 0){
                if(oddCount == 1) return false;
                else oddCount++;
            }
        }
        return true;
        

    }
}

/*

2,2,2,3,3,3

*/