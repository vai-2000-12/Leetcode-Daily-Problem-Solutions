class Solution {
    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public long maxPairStrength(int[] nums) {
        long _mx = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long nu = ((long) nums[i] * (long) nums[j]);
                long de = gcd(nums[i], nums[j]);
                de *= de;

                _mx = Math.max(_mx, nu / de);
            }
        }
        return _mx;
    }
}