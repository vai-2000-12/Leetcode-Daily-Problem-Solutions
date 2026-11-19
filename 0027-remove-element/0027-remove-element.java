class Solution {
    public int removeElement(int[] nums, int val) {
        ArrayList<Integer> lst = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                lst.add(nums[i]);
            }
        }

        for (int i = 0; i < lst.size(); i++) {
            nums[i] = lst.get(i);
        }

        return lst.size();
    }
}