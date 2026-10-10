
class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] value = new int[26];

        for (int i = 0; i < 26; i++) {
            value[i] = i + 1;
        }

        for (int i = 0; i < chars.length(); i++) {
            value[chars.charAt(i) - 'a'] = vals[i];
        }

        int maxCost = 0;
        int currentCost = 0;

        for (int i = 0; i < s.length(); i++) {
            currentCost += value[s.charAt(i) - 'a'];

            currentCost = Math.max(0, currentCost);
            maxCost = Math.max(maxCost, currentCost);
        }

        return maxCost;
    }
}
