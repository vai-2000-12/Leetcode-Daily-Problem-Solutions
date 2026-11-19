class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        ArrayList<Integer> lst = new ArrayList<>();

        if (n <= 3) {
            return 0;
        }

        int minS = Integer.MAX_VALUE;

        while (i < j) {
            int minScore = Math.abs(nums[j] - nums[i]);
            minS = Math.min(minS, minScore);
            i++;
            j--;
        }

        // Case 1
        lst.add(nums[n - 3] - nums[0]);

        // Case 2
        lst.add(nums[n - 2] - nums[1]);

        // Case 3
        lst.add(nums[n - 1] - nums[2]);

        int minA = Integer.MAX_VALUE;

        for (int val : lst) {
            minA = Math.min(val, minA);
        }

        return minA;
    }
}