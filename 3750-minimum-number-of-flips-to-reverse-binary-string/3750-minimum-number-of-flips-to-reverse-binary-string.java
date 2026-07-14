class Solution {
    public int minimumFlips(int n) {
        String s = Integer.toBinaryString(n);
        String rev = reverseStr(s);

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != rev.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    public String reverseStr(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}