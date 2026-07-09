class Solution {
    public int minLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int distinctSum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            if (map.getOrDefault(nums[right], 0) == 0) {
                distinctSum += nums[right];
            }
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (distinctSum >= k) {
                ans = Math.min(ans, right - left + 1);

                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    distinctSum -= nums[left];
                    map.remove(nums[left]);
                }

                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}