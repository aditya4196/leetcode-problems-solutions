# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        
        def traversal(curr):
            if not curr:
                return None
            
            temp = traversal(curr.left)
            curr.left = traversal(curr.right)
            curr.right = temp
            
            return curr
        
        return traversal(root)
                
        