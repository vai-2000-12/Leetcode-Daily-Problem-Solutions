class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;

        for(int i = 0 ; i< n ; i++){
            for(int j = i ; j < n ;j++){
                String sub = s.substring(i , j+1);

                if(isSemiRepitative(sub)){
                      maxLen = Math.max(maxLen , j-i+1);  
                } 
            }
        }

        return maxLen;
    }

    public boolean isSemiRepitative(String s){
         int count = 0;

    for(int i = 1; i < s.length(); i++) {
        if(s.charAt(i) == s.charAt(i - 1)) {
            count++;
        }

        if(count > 1) {
            return false;
        }
    }

    return true;

    }
}