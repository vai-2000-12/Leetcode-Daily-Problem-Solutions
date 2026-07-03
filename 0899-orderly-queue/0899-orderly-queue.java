class Solution {
    public String orderlyQueue(String s, int k) {

        ArrayList<Character> lst = new ArrayList<>();
        for (char c : s.toCharArray()) {
            lst.add(c);
        }

        if (k > 1) {
            Collections.sort(lst);

            StringBuilder sb = new StringBuilder();
            for (char c : lst) {
                sb.append(c);
            }
            return sb.toString();
        }

        String ans = s;

        for (int i = 1; i < s.length(); i++) {
            Collections.rotate(lst, -1);   // left rotate by 1

            StringBuilder sb = new StringBuilder();
            for (char c : lst) {
                sb.append(c);
            }

            String curr = sb.toString();
            if (curr.compareTo(ans) < 0) {
                ans = curr;
            }
        }

        return ans;
    }
}