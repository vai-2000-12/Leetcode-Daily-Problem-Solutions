class Solution {
    public String removeDigit(String number, char digit) {

        String ans = "";

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String curr = formNewNum(number, i);

                if (ans.equals("") || curr.compareTo(ans) > 0) {
                    ans = curr;
                }
            }
        }

        return ans;
    }

    public String formNewNum(String s, int idx) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i != idx) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}