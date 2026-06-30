class Solution {
    public String digitSum(String s, int k) {

        while (s.length() > k) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i += k) {

                String sub = s.substring(i, Math.min(i + k, s.length()));

                sb.append(getSum(sub));
            }

            s = sb.toString();
        }

        return s;
    }

    private String getSum(String str) {

        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }

        return String.valueOf(sum);
    }
}