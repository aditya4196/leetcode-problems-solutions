class Solution {
    public int[] sortByBits(int[] arr) {
        
        for(int i=0; i<arr.length; i++){
            arr[i] = countSetBits(arr[i])*10001 + arr[i];
        }
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length; i++){
            arr[i] %= 10001;
        }
        return arr;
        
    }
    public int countSetBits(int num){
        int count = 0;
        while(num != 0){
            count += (num&1);
            num >>= 1;
        }
        return count;
    }
}