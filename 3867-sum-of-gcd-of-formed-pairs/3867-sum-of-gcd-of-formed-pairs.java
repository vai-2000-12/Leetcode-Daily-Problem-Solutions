import java.util.*;

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;

        int[] prefixGCD = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixGCD[i] = getGCD(nums[i], max);
        }

        Arrays.sort(prefixGCD);

        long sum = 0;
        int i = 0, j = n - 1;

        while (i < j) {
            sum += getGCD(prefixGCD[i], prefixGCD[j]);
            i++;
            j--;
        }

        return sum;
    }

    public int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}