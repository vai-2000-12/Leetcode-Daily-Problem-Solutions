class Solution {
    public int longestPalindrome(String s, String t) {
        int maxPal = Integer.MIN_VALUE;
        int m = s.length();
        int n = t.length();

        // For the String having Length equal to 1  
        if(m == 1 && n == 1){
            String str = s.concat(t);
             if(isPalindrome(str)){
                  return str.length();
             }
             return 1;
        }

        //For the Substring from s:-
        for(int i = 0 ; i< m ; i++){
             for(int j = i ; j < m ; j++){
                String sub = s.substring(i , j+1);
                if(isPalindrome(sub)){
                    maxPal = Math.max(sub.length(), maxPal);
                }
             }
        }

        for(int i = 0 ; i< n ; i++){
             for(int j = i ; j < n ; j++){
                String sub = t.substring(i, j+1);
                if(isPalindrome(sub)){
                    maxPal = Math.max(sub.length(), maxPal);
                }
             }
       }

          for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {

                String subS = s.substring(i, j + 1);

                for (int k = 0; k < n; k++) {
                    for (int l = k; l < n; l++) {

                        String subT = t.substring(k, l + 1);

                        String str = subS.concat(subT);

                        if (isPalindrome(str)) {
                            maxPal = Math.max(maxPal, str.length());
                        }
                    }
                }
            }
        }

        return maxPal;

    }
    public boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        return rev.equals(s);
    }
}