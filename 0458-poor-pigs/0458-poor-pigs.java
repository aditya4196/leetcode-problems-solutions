class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        
        int slots = (int)Math.floor(minutesToTest/minutesToDie);
        int pigs = 0;
        
        while(Math.pow(slots+1, pigs ) < buckets){
            pigs++;
        }
        
        return pigs;
        
    }
}


/*

buckets = 5
minutestodie = 10
minutestotest = 15

30/15 = 2

2 slots
4 buckets 


slot1
pig1 = 1,2
pig2 = 3,4
slot2









*/