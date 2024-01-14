class Solution {
    public int totalFruit(int[] fruits) {

        int[] fruitCounter = new int[100001];
        int count = 0, start = 0;
        int result = 0;

        for(int end=0; end<fruits.length; end++){
            if(fruitCounter[fruits[end]]++ == 0) count++;

            while(count > 2){
                if(fruitCounter[fruits[start]]-- == 1) count--;
                start++;
            }
            result = Math.max(result, end-start+1);
        }
        return result;
        
    }
}