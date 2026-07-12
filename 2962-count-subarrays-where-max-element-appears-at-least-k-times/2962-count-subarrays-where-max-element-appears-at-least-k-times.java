class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;

        int maxEle = Integer.MIN_VALUE;
        for (int num : nums) {
            maxEle = Math.max(maxEle, num);
        }

        long ans = 0;
        int left = 0;
        int countMax = 0;

        for (int right = 0; right < n; right++) {

            if (nums[right] == maxEle) {
                countMax++;
            }

            while (countMax >= k) {
                ans += (n - right);

                if (nums[left] == maxEle) {
                    countMax--;
                }

                left++;
            }
        }

        return ans;
    }
}