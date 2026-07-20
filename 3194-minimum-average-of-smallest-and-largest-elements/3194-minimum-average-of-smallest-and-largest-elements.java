class Solution {
    public double minimumAverage(int[] nums) {

        Arrays.sort(nums);

        double ans = Double.MAX_VALUE;

        int min = 0;
        int max = nums.length - 1;

        while (min < max) {

            double avg = (nums[min] + nums[max]) / 2.0;

            ans = Math.min(ans, avg);

            min++;
            max--;
        }

        return ans;
    }

    public int getMax(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        return arr[n - 1];
    }

    public int getMin(int[] arr) {
        Arrays.sort(arr);
        return arr[0];
    }
}