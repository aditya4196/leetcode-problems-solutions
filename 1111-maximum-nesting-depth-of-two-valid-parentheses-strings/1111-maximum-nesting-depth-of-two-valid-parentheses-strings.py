class Solution:
    def maxDepthAfterSplit(self, seq: str) -> List[int]:
        ans=[]
        prev=1
        for i in seq:
            if i=='(':
                ans.append(0 if (prev == 1) else 1)
            else:
                ans.append(prev)
            prev = 0 if (prev == 1) else 1
        return ans