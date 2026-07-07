class Solution {
    public int equalSubstring(String s, String t, int maxCost){
        int m = s.length();
        int n = t.length();
        //Boundary Condition:-
        if( m != n) return -1;

        int left = 0;
        int cost = 0;
        int maxLen = 0;


        
        for (int right = 0; right < m; right++) {

            cost += Math.abs(s.charAt(right) - t.charAt(right));

            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;        

    }
}