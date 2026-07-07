class Solution {
    public long sumAndMultiply(int n) {
        String s = getNewDigitExcldZero(n);

        long x = s.isEmpty() ? 0 : Long.parseLong(s);

        long sum = 0;
        for (char ch : s.toCharArray()) {
            sum += ch - '0';
        }

        return x * sum;
    }

    public String getNewDigitExcldZero(int n) {
        StringBuilder sb = new StringBuilder();

        for (char ch : String.valueOf(n).toCharArray()) {
            if (ch != '0') {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}