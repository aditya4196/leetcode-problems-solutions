class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int n1ptr = m-1, n2ptr = n-1, k = m+n-1;
        
        while(n1ptr >= 0 || n2ptr >= 0){
            int leftVal = (n1ptr < 0)?Integer.MIN_VALUE:nums1[n1ptr];
            int rightVal = (n2ptr < 0)?Integer.MIN_VALUE:nums2[n2ptr];
            
            if(leftVal > rightVal){
                nums1[k--] = nums1[n1ptr--];
            }
            else nums1[k--] = nums2[n2ptr--];
        }
        
    }
}