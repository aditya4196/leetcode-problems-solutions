/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        
        if(reader.get(0) == target) return 0;
        
        int[] boundaries = getBoundaries(reader, target);
        int left = boundaries[0], right = boundaries[1];
        
        while(left <= right){
            int mid = left + (right-left)/2;
            int val = reader.get(mid);
            
            if(val == target) return mid;
            else if(val > target) right = mid-1;
            else left = mid+1;
        }
        
        return -1;
        
        
        
    }
    
    public int[] getBoundaries(ArrayReader reader, int target){
        int right = 1, left = 0;
        while(reader.get(right) != Integer.MAX_VALUE && reader.get(right) < target){
            left = right;
            right <<= 2;
        }
        return new int[]{left, right};
    }
}

/*







*/