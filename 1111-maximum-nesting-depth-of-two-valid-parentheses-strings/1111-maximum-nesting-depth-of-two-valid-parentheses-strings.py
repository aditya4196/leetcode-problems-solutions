class Solution:
    def maxDepthAfterSplit(self, seq: str) -> List[int]:
        result = []
        depth = 1
        for c in seq:
            if c == '(':
                result.append(0 if (depth == 1) else 1)
            else:
                result.append(depth)
            depth = 0 if (depth == 1) else 1
        return result