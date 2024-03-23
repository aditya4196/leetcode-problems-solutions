class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        int target = nums.length - k + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countNumberLessThan(nums, mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
    
    private static int countNumberLessThan(int[] array, int mid) {
        int count = 0;
        for (int num : array) {
            if (num <= mid) {
                count++;
            }
        }
        return count;
    }
}