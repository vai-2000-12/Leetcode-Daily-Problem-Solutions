
class Solution {
    public int calculateScore(int a, int b) {
        int score = 0;
        String s1 = Integer.toBinaryString(a);
        String s2 = Integer.toBinaryString(b);

        int count1 = 0;
        int count2 = 0;

        for (char c : s1.toCharArray()) {
            if (c == '1') {
                count1++;
            }
        }

        for (char c2 : s2.toCharArray()) {
            if (c2 == '1') {
                count2++;
            }
        }

        if (count1 >= count2) {
            score = count1 * count2;
        } else {
            score = count2 / count1;
        }

        return score;
    }
}
