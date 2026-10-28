class TrieNode {
    TrieNode[] child;
    boolean isEnd;

    public TrieNode() {
        child = new TrieNode[26];
        isEnd = false;
    }
}

class Solution {

    TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();

        for (String str : dictionary) {
            insert(str);
        }

        for (String str : queries) {
            if (search(str, root, new StringBuilder())) {
                ans.add(str);
            }
        }

        return ans;
    }

    public void insert(String s) {
        int n = s.length();
        TrieNode curr = root;

        for (int i = 0; i < n; i++) {
            int indx = s.charAt(i) - 'a';

            if (curr.child[indx] == null) {
                curr.child[indx] = new TrieNode();
            }

            curr = curr.child[indx];
        }

        curr.isEnd = true;
    }

    public boolean search(String s, TrieNode curr, StringBuilder dictionary) {
        if (dictionary.length() == s.length()) {
            return curr.isEnd &&
                   CharacterMismatchInString(s, dictionary.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (curr.child[i] != null) {
                dictionary.append((char) ('a' + i));

                if (search(s, curr.child[i], dictionary)) {
                    return true;
                }

                dictionary.deleteCharAt(dictionary.length() - 1);
            }
        }

        return false;
    }

    public boolean CharacterMismatchInString(String s, String dictionary) {
        int m = s.length();
        int n = dictionary.length();

        int edits = 0;
        int maxEdits = 2;

        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != dictionary.charAt(i)) {
                edits++;
            }

            if (edits > maxEdits) {
                return false;
            }
        }

        return true;
    }
}