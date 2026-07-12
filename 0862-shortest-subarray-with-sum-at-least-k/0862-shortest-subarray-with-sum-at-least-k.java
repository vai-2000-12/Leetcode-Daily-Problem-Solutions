import java.util.*;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;

        // Prefix Sum (long to avoid overflow)
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {

            // Check if current prefix - smallest prefix >= k
            while (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= k) {
                minLen = Math.min(minLen, i - dq.pollFirst());
            }

            // Maintain increasing order of prefix sums
            while (!dq.isEmpty() && prefix[i] <= prefix[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}