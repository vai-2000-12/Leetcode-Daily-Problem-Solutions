class Solution {
    public int longestDecomposition(String text) {

        int n = text.length();
        int k = 0;

        int i = 0;
        int j = n - 1;

        while (i <= j) {

            boolean found = false;

            for (int end = i; end < j; end++) {

                String sub = text.substring(i, end + 1);

                if (concatOfSubIsEqualToText(text, sub, i, j)) {

                    k += 2;

                    i = end + 1;
                    j = j - sub.length();

                    found = true;
                    break;
                }
            }

            if (!found) {
                k++;
                break;
            }
        }

        return k;
    }

    public boolean concatOfSubIsEqualToText(
            String text, String sub, int left, int right) {

        int len = sub.length();

        // Right side ka same length ka substring
        String rightSub =
                text.substring(right - len + 1, right + 1);

        return sub.equals(rightSub);
    }
}