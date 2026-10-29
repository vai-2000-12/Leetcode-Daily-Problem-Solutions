class TrieNode{
     TrieNode[] child;
     boolean isEnd;

     public TrieNode(){
         child = new TrieNode[26];
         isEnd = false;
     }       
}
class Solution {
    TrieNode root;

    public Solution(){
         root = new TrieNode();
    }


    public String replaceWords(List<String> dictionary, String sentence) {
       for(String s : dictionary)
       {
          insert(s);
       }
       String[] str = sentence.split(" ");
     StringBuilder ans = new StringBuilder();

        for (String s : str) {
            String replaced = search(s);

            if (ans.length() > 0) {
                ans.append(" ");
            }

            ans.append(replaced);
        }

        return ans.toString();

    }

  
    public void insert(String s) {
        TrieNode curr = root;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';

            if (curr.child[idx] == null) {
                curr.child[idx] = new TrieNode();
            }

            curr = curr.child[idx];
        }

        curr.isEnd = true;
    }
     public String search(String s) {
        TrieNode curr = root;
        StringBuilder prefix = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';

            if (curr.child[idx] == null) {
                return s;
            }

            prefix.append(ch);
            curr = curr.child[idx];

            if (curr.isEnd) {
                return prefix.toString();
            }
        }
        return s;
    }
}