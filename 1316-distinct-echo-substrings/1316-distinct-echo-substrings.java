import java.util.*;

class Solution {
    public int distinctEchoSubstrings(String text) {

        HashSet<String> set = new HashSet<>();
        int n = text.length();

        for (int i = 0; i < n; i++) {

            for (int len = 2; i + len <= n; len += 2) {

                int half = len / 2;
                boolean same = true;

                for (int k = 0; k < half; k++) {
                    if (text.charAt(i + k) != text.charAt(i + half + k)) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    set.add(text.substring(i, i + len));
                }
            }
        }

        return set.size();
    }
}