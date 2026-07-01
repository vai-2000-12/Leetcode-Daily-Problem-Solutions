class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i];

            String word = words[i];
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);

            if (isVowel(first) && isVowel(last)) {
                prefix[i + 1]++;
            }
        }

        int[] ans = new int[queries.length];
        int i = 0;

        for (int[] q : queries) {
            int stIndx = q[0];
            int endIndx = q[1];

            ans[i++] = prefix[endIndx + 1] - prefix[stIndx];
        }

        return ans;
    }

    public String getString(String[] s) {
        StringBuilder sb = new StringBuilder();
        for (String word : s) {
            sb.append(word);
        }
        return sb.toString();
    }

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i'
            || ch == 'o' || ch == 'u';
    }
}