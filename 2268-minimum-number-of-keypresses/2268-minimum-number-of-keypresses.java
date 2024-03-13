class Solution {
    public int minimumKeypresses(String s) {
        
        int[] count = new int[26];
        
        for(char c : s.toCharArray()) count[c-'a']++;
        PriorityQueue<Character> pq = new PriorityQueue<Character>((a,b) -> (count[b-'a'] - count[a-'a']));
        
        for(int i=0; i<26; i++){
            if(count[i] > 0) pq.offer((char)(i + 'a'));
        }
        
        int size = pq.size();
        int times = 0;
        int result = 0;
        
        for(int i=1; i<=size; i++){
            int currCount = count[pq.poll()-'a'];
            
            if(i>9 && i<=18){
                result = result + (currCount*2);
            }
            else if(i>18) result = result + (currCount*3);
            else result += currCount;
        }
        
        return result;
        
        
    }
}

/*


apple

p - 2
a - 1
l - 1
e - 1




1 - 
2 - 
3 -
4 -
5 -
6 -
7 -
8 -
9 -





*/