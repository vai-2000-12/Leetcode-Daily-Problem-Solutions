
class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;

        for (String str : words) {
            if (checkIfCharacterAreContinousRepeating(s, str)) {
                count++;
            }
        }

        return count;
    }

    public boolean checkIfCharacterAreContinousRepeating(String s, String str) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < str.length()) {

            if (s.charAt(i) != str.charAt(j)) {
                return false;
            }

            char ch = s.charAt(i);

            int count1 = 0;
            int count2 = 0;

            while (i < s.length() && s.charAt(i) == ch) {
                count1++;
                i++;
            }

            while (j < str.length() && str.charAt(j) == ch) {
                count2++;
                j++;
            }

            if (count1 < count2) {
                return false;
            }

            if (count1 != count2 && count1 < 3) {
                return false;
            }
        }

        return i == s.length() && j == str.length();
    }
}
