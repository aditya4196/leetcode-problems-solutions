class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int ptr1 = m-1, ptr2 = n-1;
        
        for(int rptr = (m+n-1); rptr >= 0; rptr--){
            if(ptr1 >= 0 && ptr2 >= 0){
                nums1[rptr] = (nums1[ptr1] > nums2[ptr2])?(nums1[ptr1--]):(nums2[ptr2--]);
            }
            else nums1[rptr] = (ptr1 < 0)?(nums2[ptr2--]):(nums1[ptr1--]);
        }
        
    }
}
/*


nums1 = [1 2 3 3 5 6]
         i
nums2 = [2 5 6]
         j

*/