class Solution:
    def numberOfMatches(self, n: int) -> int:
        matchesPlayed = 0
        teams = n
        
        while teams > 1:
            if teams%2 == 0:
                matchesPlayed += teams//2
                teams = teams//2
            else:
                matchesPlayed += (teams-1)//2
                teams = ((teams-1)//2) + 1
                
        return matchesPlayed
            
        
        