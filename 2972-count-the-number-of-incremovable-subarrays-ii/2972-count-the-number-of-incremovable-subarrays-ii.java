class Solution {
    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;

        // Longest increasing prefix
        int left = 0;
        while (left + 1 < n && nums[left] < nums[left + 1]) {
            left++;
        }

        // Entire array is strictly increasing
        if (left == n - 1) {
            return (long) n * (n + 1) / 2;
        }

        long count = left + 2;

        // Longest increasing suffix
        int right = n - 1;

        while (right > 0) {

            while (left >= 0 && nums[left] >= nums[right]) {
                left--;
            }

            count += left + 2;

            if (right > 0 && nums[right - 1] >= nums[right]) {
                break;
            }

            right--;
        }

        return count;
    }
}