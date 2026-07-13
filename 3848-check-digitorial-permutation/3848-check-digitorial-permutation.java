class Solution {
    public boolean isDigitorialPermutation(int n) {
        int original = n;
        int sum = 0;

        List<Integer> digits = getDigits(n);

        for (int digit : digits) {
            sum += getFactorialOfDigit(digit);
        }

        List<Integer> originalDigits = getDigits(original);
        List<Integer> sumDigits = getDigits(sum);

        Collections.sort(originalDigits);
        Collections.sort(sumDigits);

        return originalDigits.equals(sumDigits);
    }

    public List<Integer> getDigits(int n) {
        List<Integer> digitList = new ArrayList<>();

        if (n == 0) {
            digitList.add(0);
            return digitList;
        }

        while (n != 0) {
            int digit = n % 10;
            digitList.add(digit);
            n /= 10;
        }

        return digitList;
    }

    public int getFactorialOfDigit(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }

        return num * getFactorialOfDigit(num - 1);
    }
}