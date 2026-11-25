
class Solution {

    public boolean judgeSquareSum(int c) {

        long a = 0;

        while (a * a <= c) {

            long remaining = c - (a * a);

            long b = (long) Math.sqrt(remaining);

            if (b * b == remaining) {
                return true;
            }

            a++;
        }

        return false;
    }
}
