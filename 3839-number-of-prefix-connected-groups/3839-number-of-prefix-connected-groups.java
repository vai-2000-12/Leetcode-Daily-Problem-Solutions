class TrieNode{
     TrieNode[]child;
     boolean isEnd;
    int count;
     public TrieNode(){
          child = new TrieNode[26];
          isEnd = false;
          count = 0;
     }
}
class Solution {
      
      TrieNode root;

      public Solution(){
         root = new TrieNode();
      }
    
    public int prefixConnected(String[] words, int k) {
          for (String s : words) {
            if (s.length() >= k) {
                insert(s.substring(0, k));
            }
        }

        return prefix(root);
    }

    public void insert(String s){
         TrieNode curr = root;
         int n = s.length();
         
         for(int i = 0 ; i < n; i++){
            int  indx = s.charAt(i)-'a';

            if(curr.child[indx] == null){
                 curr.child[indx] = new TrieNode();
            }
            curr = curr.child[indx];
         }
         curr.isEnd = true;
         curr.count++;
    }

   public int prefix(TrieNode root) {
        int ans = 0;

        if (root == null)
            return 0;

        if (root.isEnd && root.count >= 2)
            ans++;

        for (int i = 0; i < 26; i++) {
            ans += prefix(root.child[i]);
        }

        return ans;
    }
}
