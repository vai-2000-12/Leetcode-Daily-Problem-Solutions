class Solution {
    public int totalSteps(int[] nums) {
         int n = nums.length;
        int[] dp = new int[n];
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                dp[i] = Math.max(dp[i] + 1, dp[st.pop()]);
            }
            ans = Math.max(ans, dp[i]);
            st.push(i);
        }

        return ans;
    }
}