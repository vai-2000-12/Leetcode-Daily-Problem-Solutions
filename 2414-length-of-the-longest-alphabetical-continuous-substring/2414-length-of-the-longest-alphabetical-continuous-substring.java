class Solution {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        int start = 0;
        int max = 1;

        for(int i = 1; i < n; i++){

            if(s.charAt(i) != s.charAt(i - 1) + 1){
                String sub = s.substring(start, i);

                max = Math.max(max, sub.length());

                start = i;
            }
        }

        String sub = s.substring(start, n);
        max = Math.max(max, sub.length());

        return max;
    }
}