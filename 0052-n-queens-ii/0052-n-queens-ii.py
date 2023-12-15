class Solution:
    def totalNQueens(self, n: int) -> int:
        
        def backtrack(row, curr, colset, leftset, rightset):
            if row == n:
                return 1
            
            result = 0
            for col in range(n):
                left = row-col
                right = row+col
                
                if col in colset or left in leftset or right in rightset:
                    continue
                
                curr[row][col] = 'Q'
                result += backtrack(row+1, curr, colset | {col}, leftset | {left}, rightset | {right})
                curr[row][col] = '.'
            
            return result


        board = [['.']*n for _ in range(n)]
        return backtrack(0, board, set(), set(), set())

                
        