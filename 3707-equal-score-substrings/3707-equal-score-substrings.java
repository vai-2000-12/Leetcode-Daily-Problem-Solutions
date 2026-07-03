class Solution {
    public boolean scoreBalance(String s) {
        int n = s.length();

        for (int i = 0; i < n - 1; i++) {
            String left = s.substring(0, i + 1);
            String right = s.substring(i + 1);

            if (haveEqualScore(left, right)) {
                return true;
            }
        }
        return false;
    }

    public boolean haveEqualScore(String left, String right) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, c - 'a' + 1);
        }

        int leftScore = 0;
        int rightScore = 0;

        for (char c : left.toCharArray()) {
            leftScore += map.get(c);
        }

        for (char c : right.toCharArray()) {
            rightScore += map.get(c);
        }

        return leftScore == rightScore;
    }
}