class Solution {
    public int[] concatWithReverse(int[] nums) {

        int[] rev = reverse(nums);
        int[] ans = new int[nums.length + rev.length];

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            ans[index++] = nums[i];
        }

        for (int i = 0; i < rev.length; i++) {
            ans[index++] = rev[i];
        }

        return ans;
    }

    public int[] reverse(int[] nums) {
        int[] temp = nums.clone();

        int i = 0;
        int j = temp.length - 1;

        while (i < j) {
            int t = temp[i];
            temp[i] = temp[j];
            temp[j] = t;
            i++;
            j--;
        }

        return temp;
    }
}