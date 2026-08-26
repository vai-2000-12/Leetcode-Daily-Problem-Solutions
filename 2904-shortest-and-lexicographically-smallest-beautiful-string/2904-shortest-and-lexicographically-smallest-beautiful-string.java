class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[2];
        boolean isEnd;
    }

    TrieNode root = new TrieNode();

    void insert(String str) {
        TrieNode curr = root;

        for (char ch : str.toCharArray()) {
            int idx = ch - '0';

            if (curr.child[idx] == null) {
                curr.child[idx] = new TrieNode();
            }

            curr = curr.child[idx];
        }

        curr.isEnd = true;
    }

    // Trie mein lexicographically smallest string find karega
    String getSmallest() {
        StringBuilder ans = new StringBuilder();
        TrieNode curr = root;

        while (!curr.isEnd) {

            // '0' pehle aata hai, isliye pehle 0 check karenge
            if (curr.child[0] != null) {
                ans.append('0');
                curr = curr.child[0];
            } 
            else {
                ans.append('1');
                curr = curr.child[1];
            }
        }

        return ans.toString();
    }

    public String shortestBeautifulSubstring(String s, int k) {

        int n = s.length();

        int minLen = Integer.MAX_VALUE;

        // ------------------------------------------------
        // STEP 1:
        // Saari beautiful substrings check karo
        // aur minimum length find karo
        // ------------------------------------------------

        for (int i = 0; i < n; i++) {

            int ones = 0;

            for (int j = i; j < n; j++) {

                if (s.charAt(j) == '1') {
                    ones++;
                }

                // Exactly k ones => beautiful substring
                if (ones == k) {

                    int len = j - i + 1;

                    minLen = Math.min(minLen, len);

                    // Iske baad aur characters add karne se
                    // ones > k ho jayenge ya length badhegi,
                    // so break kar sakte hain
                    break;
                }

                if (ones > k) {
                    break;
                }
            }
        }

        // Koi beautiful substring hi nahi mila
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        // ------------------------------------------------
        // STEP 2:
        // Root reset karo
        // Ab sirf minimum-length beautiful substrings
        // Trie mein insert karenge
        // ------------------------------------------------

        root = new TrieNode();

        for (int i = 0; i < n; i++) {

            int ones = 0;

            for (int j = i; j < n; j++) {

                if (s.charAt(j) == '1') {
                    ones++;
                }

                if (ones == k) {

                    int len = j - i + 1;

                    // Sirf shortest beautiful substrings
                    if (len == minLen) {
                        String sub = s.substring(i, j + 1);

                        insert(sub);
                    }

                    break;
                }

                if (ones > k) {
                    break;
                }
            }
        }

        // ------------------------------------------------
        // STEP 3:
        // Trie se lexicographically smallest string
        // ------------------------------------------------

        return getSmallest();
    }
}