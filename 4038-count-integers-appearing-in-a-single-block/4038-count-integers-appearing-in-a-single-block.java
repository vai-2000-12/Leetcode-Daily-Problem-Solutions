class Solution {
    public int countSpecialIntegers(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int count = 0;

        for (int key : map.keySet()) {
            int first = -1;
            int last = -1;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == key) {
                    if (first == -1) {
                        first = i;
                    }
                    last = i;
                }
            }

            boolean special = true;

            for (int i = first; i <= last; i++) {
                if (nums[i] != key) {
                    special = false;
                    break;
                }
            }

            if (special) {
                count++;
            }
        }

        return count;
    }
}