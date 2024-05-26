/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function(root) {
    
    if(root === null) return null;
    if(root.left !== null && root.right !== null){
        const temp = root.left;
        root.left = root.right;
        root.right = temp;
    } 
    else if(root.left === null){
        root.left = root.right;
        root.right = null;
    }
    else{
        root.right = root.left;
        root.left = null;
    }
    
    invertTree(root.left);
    invertTree(root.right);
    
    return root;
    
};