class Solution {
    public int maxDigitRange(int[] nums) {
        int maxRange = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            int range = getLargetAndSmallestFromDigitOfNumber(getDigit(num));
            maxRange = Math.max(maxRange, range);
        }

        for (int num : nums) {
            int range = getLargetAndSmallestFromDigitOfNumber(getDigit(num));
            if (range == maxRange) {
                sum += num;
            }
        }

        return sum;
    }

    public List<Integer> getDigit(int n) {
        List<Integer> lst = new ArrayList<>();

        if (n == 0) {
            lst.add(0);
            return lst;
        }

        while (n != 0) {
            int digit = n % 10;
            lst.add(digit);
            n /= 10;
        }

        return lst;
    }

    public int getLargetAndSmallestFromDigitOfNumber(List<Integer> lst) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int e : lst) {
            max = Math.max(max, e);
            min = Math.min(min, e);
        }

        return max - min;
    }
}