class Solution {
    public int subsetXORSum(int[] nums) {
        return solve(nums, 0, 0);
    }

    public int solve(int[] nums, int index, int xor) {
        if (index == nums.length) {
            return xor;
        }

        // Current element ko nahi liya
        int notTake = solve(nums, index + 1, xor);

        // Current element ko liya
        int take = solve(nums, index + 1, xor ^ nums[index]);

        return take + notTake;
    }
}