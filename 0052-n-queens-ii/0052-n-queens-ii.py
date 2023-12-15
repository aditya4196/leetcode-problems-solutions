class Solution:
    def totalNQueens(self, n: int) -> int:
        
        def backtrack(row, curr, colset, leftset, rightset):
            nonlocal result
            if row == n:
                result += 1
                return
            
            for col in range(n):
                left = row-col
                right = row+col
                
                if col in colset or left in leftset or right in rightset:
                    continue
                
                curr[row][col] = 'Q'
                backtrack(row+1, curr, colset | {col}, leftset | {left}, rightset | {right})
                curr[row][col] = '.'

        result = 0
        board = [['.']*n for _ in range(n)]
        backtrack(0, board, set(), set(), set())
        return result
                
        