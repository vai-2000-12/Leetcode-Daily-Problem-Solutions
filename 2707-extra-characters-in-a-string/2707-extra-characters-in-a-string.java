import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode curr = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (curr.child[idx] == null)
                curr.child[idx] = new TrieNode();

            curr = curr.child[idx];
        }

        curr.isEnd = true;
    }

    public int solve(int index, String s, int[] dp) {

        if (index == s.length())
            return 0;

        if (dp[index] != -1)
            return dp[index];

        // Option 1: Current character is extra
        int ans = 1 + solve(index + 1, s, dp);

        TrieNode curr = root;

        // Option 2: Try every dictionary word starting from index
        for (int j = index; j < s.length(); j++) {

            int idx = s.charAt(j) - 'a';

            if (curr.child[idx] == null)
                break;

            curr = curr.child[idx];

            if (curr.isEnd) {
                ans = Math.min(ans, solve(j + 1, s, dp));
            }
        }

        return dp[index] = ans;
    }

    public int minExtraChar(String s, String[] dictionary) {

        for (String word : dictionary)
            insert(word);

        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return solve(0, s, dp);
    }
}