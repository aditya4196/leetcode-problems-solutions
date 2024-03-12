class Solution {
    public int countOrders(int n) {
        
        if(n == 1) return 1;
        long modulo = (long)Math.pow(10,9)+7l;
        
        long result = 1;
        
        for(int i=1; i<=n; i++){
            result = (result*i)%modulo;
            result = (result*(2*i-1))%modulo;
        }
        
        return (int)(result%modulo);
        
        
        
    }
}

/*

n = 3


p1 d1 p2 d2 p3 d3
p1 d1 p2 p3 d2 d3
p1 p2 d1 d2 

_ _
_ _ _ _ _ _






(P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).




*/