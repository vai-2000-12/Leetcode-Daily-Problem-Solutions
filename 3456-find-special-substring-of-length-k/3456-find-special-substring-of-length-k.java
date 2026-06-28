class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
       int n = s.length();

        for (int i = 0; i <= n - k; i++) {
            if (isExists(s, i, i + k - 1)) {
                return true;
            }
        }

        return false;
    }

    public boolean isExists(String s, int st , int end){
    char c = s.charAt(st);
    int n = s.length();

    for(int i = st ; i <= end ; i++){
        if(s.charAt(i) != c){
            return false;
        }
    }
       
       if(st > 0 && s.charAt(st-1) == c){
         return false; 
       }

       if(end < n-1 && s.charAt(end + 1) == c){
        return false;
       }
        return true;
    }
}