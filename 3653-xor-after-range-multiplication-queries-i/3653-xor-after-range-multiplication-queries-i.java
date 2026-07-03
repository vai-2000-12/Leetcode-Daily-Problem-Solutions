class Solution {
    int MOD = 1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
         int n = nums.length;
         for(int[] q : queries){
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

           for (int idx = l; idx <= r; idx += k) {
                nums[idx] = (int) (((long) nums[idx] * v) % MOD);
            }
         } 

          int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}