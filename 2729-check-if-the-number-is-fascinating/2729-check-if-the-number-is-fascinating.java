import java.util.HashSet;

class Solution {
    public boolean isFascinating(int n) {
        int num1 = 2 * n;
        int num2 = 3 * n;

        String s = formNumber(n, num1, num2);

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';

            // 0 is not allowed and digits should not repeat
            if (digit == 0 || set.contains(digit)) {
                return false;
            }

            set.add(digit);
        }

        return set.size() == 9;
    }

    public String formNumber(int n, int num1, int num2) {
        String s1 = Integer.toString(n);
        String s2 = Integer.toString(num1);
        String s3 = Integer.toString(num2);

        return s1.concat(s2).concat(s3);
    }
}