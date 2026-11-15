class Solution {
    public boolean checkRecord(String s) {
         HashMap<Character , Integer > map = new HashMap<>();
         int n = s.length();
         for(int i = 0 ; i < n ; i++)
        {
            char c = s.charAt(i);
            map.put(c , map.getOrDefault(c, 0)+1);
        }           

         // Condition 1: Total absences must be less than 2
        if (map.getOrDefault('A', 0) >= 2) {
            return false;
        }

        // Condition 2: No 3 consecutive late days
        for (int i = 0; i <= s.length() - 3; i++) {
            if (s.charAt(i) == 'L' &&
                s.charAt(i + 1) == 'L' &&
                s.charAt(i + 2) == 'L') {
                return false;
            }
        }

        return true;
     
    }
}