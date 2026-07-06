class Solution {
    public int concatenatedBinary(int n) {
        List<String> curr = getNumbersInRange(n);
        StringBuilder sb = new StringBuilder();

        for (String s : curr) {
            sb.append(s);
        }

        long mod = 1000000007;
        long ans = 0;

        for (int i = 0; i < sb.length(); i++) {
            ans = (ans * 2 + (sb.charAt(i) - '0')) % mod;
        }

        return (int) ans;
    }

    public List<String> getNumbersInRange(int n) {
        List<String> lst = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            lst.add(Integer.toBinaryString(i));
        }
        return lst;
    }
}
