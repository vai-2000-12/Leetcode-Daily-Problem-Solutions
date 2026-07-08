class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int count = 0;

        // Prefix Sum
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Check every subarray
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                long sum = prefix[j + 1] - prefix[i];

                if (isValid(sum, x)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isValid(long sum, int x) {
        int lastDigit = (int) (sum % 10);

        long temp = sum;
        while (temp >= 10) {
            temp /= 10;
        }

        int firstDigit = (int) temp;

        return firstDigit == x && lastDigit == x;
    }
}