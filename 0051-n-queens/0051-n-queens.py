class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        def createboard(state):
            board = []
            for row in state:
                board.append("".join(row))
            return board
                    
        
        def backtrack(state, row, colset, ldiagset, rdiagset):
            if row == n:
                result.append(createboard(state))
                return
            
            for col in range(n):
                ldiag = row-col
                rdiag = row+col
                
                if col in colset or ldiag in ldiagset or rdiag in rdiagset:
                    continue
                
                state[row][col] = 'Q'
                backtrack(state, row+1, colset | {col}, ldiagset | {ldiag}, rdiagset | {rdiag})
                state[row][col] = '.'
            
                
        
        
        
        
        result = []
        empty_board = [["."]*n for _ in range(n)]
        backtrack(empty_board, 0, set(), set(), set())
        return result
        