class Solution {
    public int partitionString(String s) {
        int[] last = new int[26];
        
        Arrays.fill(last, -1);
        int total = 1, start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (last[s.charAt(i) - 'a'] >= start) {
                total++;
                start = i;
            }
            last[s.charAt(i) - 'a'] = i;
        }

        return total;
    }
}