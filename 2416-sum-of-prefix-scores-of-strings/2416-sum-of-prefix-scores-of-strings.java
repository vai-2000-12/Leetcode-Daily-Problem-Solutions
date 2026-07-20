class TrieNode{
    TrieNode[] child;
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

    public int[] sumPrefixScores(String[] words) {
        
        // Insert all words
        for(String word : words){
            insert(word);
        }

        int n = words.length;
        int[] ans = new int[n];

        // Find prefix scores
        for(int i = 0; i < n; i++){
            ans[i] = getPrefixLen(words[i]);
        }

        return ans;
    }

    public void insert(String s){
        TrieNode curr = root;
        int n = s.length();

        for(int i = 0 ; i < n ; i++){
           int indx = s.charAt(i)-'a';

           if(curr.child[indx] == null){
               curr.child[indx] = new TrieNode();
           }

           curr = curr.child[indx];

           // number of words having this prefix
           curr.count++;
        }

        curr.isEnd = true;
    }

    public int getPrefixLen(String s){
        TrieNode curr = root;
        int sum = 0;

        for(int i = 0; i < s.length(); i++){
            int indx = s.charAt(i)-'a';

            curr = curr.child[indx];

            sum += curr.count;
        }

        return sum;
    }
}