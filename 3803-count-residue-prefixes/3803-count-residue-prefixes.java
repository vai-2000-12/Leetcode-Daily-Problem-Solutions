class Solution {
    public int residuePrefixes(String s) {
      int n = s.length();
      int count =  0;
      for (int j = 0; j < n; j++) {
            String prefix = s.substring(0, j + 1);
            if (isPrefixAResidue(prefix)) {
                count++;
            }
        }
    return count;
    }
    public boolean isPrefixAResidue(String s){
        int len = s.length();
        HashSet<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
        }

        int si = set.size();
        int val = len % 3;
        return si == val;
    }
}