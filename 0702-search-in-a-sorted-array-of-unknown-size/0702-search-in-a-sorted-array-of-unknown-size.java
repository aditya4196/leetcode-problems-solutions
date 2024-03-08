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
        
        int right = rightIndex(reader, target), left = 0;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            int val = reader.get(mid);
            
            if(val == target) return mid;
            else if(val > target) right = mid-1;
            else left = mid+1;
        }
        
        return -1;
        
        
        
    }
    
    public int rightIndex(ArrayReader reader, int target){
        int idx = 1;
        while(reader.get(idx) != Integer.MAX_VALUE && reader.get(idx) < target){
            idx = idx*2;
        }
        
        return idx;
    }
}

/*







*/