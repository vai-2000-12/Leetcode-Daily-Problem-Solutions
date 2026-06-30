class Solution {

    public boolean validMountainArray(int[] arr) {

        if (arr.length < 3) {
            return false;
        }

        int peak = 0;

        while (peak < arr.length - 1 && arr[peak] < arr[peak + 1]) {
            peak++;
        }

        if (peak == 0 || peak == arr.length - 1) {
            return false;
        }

        return isInc(arr, 0, peak) && isDec(arr, peak, arr.length - 1);
    }

    public boolean isInc(int[] arr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] <= arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isDec(int[] arr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] >= arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}