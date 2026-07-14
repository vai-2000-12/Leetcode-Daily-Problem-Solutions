class Solution {
    int ans = 0;
    public int maxProduct(String s) {
        solve(0, s, "", "");
        return ans;
    }
    public void solve(int idx, String s , String s1 , String s2){
          if (idx == s.length()) {
            ans = Math.max(ans, getLen(s1) * getLen(s2));
            return;
        }

        // Current character first subsequence me
        solve(idx + 1, s, s1 + s.charAt(idx), s2);

        // Current character second subsequence me
        solve(idx + 1, s, s1, s2 + s.charAt(idx));

        // Current character skip
        solve(idx + 1, s, s1, s2);
    }
    public boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        String str = sb.reverse().toString();
        return str.equals(s);
    }
    public int getLen(String s){
        if(isPalindrome(s)){
             return s.length();
        }
        return 0;
    }
}