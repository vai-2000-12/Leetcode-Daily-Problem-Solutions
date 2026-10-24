class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] sub = Arrays.copyOfRange(nums, i, j + 1);

                if (checkIfSubContainsKElementsAndDivByP(sub, k, p)) {
                    set.add(Arrays.toString(sub));
                }
            }
        }

        return set.size();
    }

    public boolean checkIfSubContainsKElementsAndDivByP(
            int[] nums, int k, int p) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % p == 0) {
                count++;
            }

            if (count > k) {
                return false;
            }
        }

        return true;
    }
}