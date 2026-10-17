class Solution {
    public int minSwaps(int[] nums) {
        LinkedHashMap<Integer, Integer> resMap = calSumDigitAndMapTothatNum(nums);
        int minSwapCount = 0;
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            int sumA = calDigitSum(a);
            int sumB = calDigitSum(b);

            if (sumA == sumB) {
                return Integer.compare(a, b);
            }
            return Integer.compare(sumA, sumB);
        });

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] || map.get(nums[i]) == i) {
                continue;
            }

            int j = i;
            int cycleSize = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = map.get(nums[j]);
                cycleSize++;
            }

            if (cycleSize > 1) {
                minSwapCount += cycleSize - 1;
            }
        }

        return minSwapCount;
    }

    public LinkedHashMap<Integer, Integer> calSumDigitAndMapTothatNum(int[] arr) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], calDigitSum(arr[i]));
        }

        return map;
    }

    public int calDigitSum(int n) {
        int sum = 0;

        while (n != 0) {
            int digit = n % 10;
            sum += digit;
            n /= 10;
        }

        return sum;
    }
}