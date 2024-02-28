class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> result = new ArrayList();
        
        int n1 = nums1.length, n2 = nums2.length;
        int i=0, j=0;
        
        while(i < n1 && j < n2){
            if(nums1[i] == nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] > nums2[j]) j++;
            else i++;
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
        
        
        
    }
}

