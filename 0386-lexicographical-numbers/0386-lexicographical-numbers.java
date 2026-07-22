class TrieNode {
    TrieNode[] child;
    boolean isEnd;

    public TrieNode() {
        child = new TrieNode[10];
        isEnd = false;
    }
}

class Solution {

    TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    public List<Integer> lexicalOrder(int n) {

        for (int i = 1; i <= n; i++) {
            insert(Integer.toString(i));
        }

        List<Integer> ans = new ArrayList<>();
        dfs(root, new StringBuilder(), ans);

        return ans;
    }

    public void insert(String s) {

        TrieNode curr = root;

        for (char ch : s.toCharArray()) {
            int idx = ch - '0';

            if (curr.child[idx] == null) {
                curr.child[idx] = new TrieNode();
            }

            curr = curr.child[idx];
        }

        curr.isEnd = true;
    }

    public void dfs(TrieNode node, StringBuilder sb, List<Integer> ans) {

        if (node == null) return;

        if (node.isEnd) {
            ans.add(Integer.parseInt(sb.toString()));
        }

        for (int i = 0; i < 10; i++) {
            if (node.child[i] != null) {
                sb.append(i);
                dfs(node.child[i], sb, ans);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}