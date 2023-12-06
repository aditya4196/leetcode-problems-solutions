"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        result = []
        stack = [root]
        
        while root and stack:
            curr = stack.pop()
            result.append(curr.val)
            
            for i in range(len(curr.children)-1, -1, -1):
                stack.append(curr.children[i])
            
        return result
        

        
            
            
        
        
        
        
        