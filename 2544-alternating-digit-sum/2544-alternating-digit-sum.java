class Solution {
    public int alternateDigitSum(int n) {
        String s = String.valueOf(n);
        int sum = 0;
        boolean turn = true;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(turn){
                sum = sum + (ch-'0');
                turn = false;
            }
            else {
                sum = sum - (ch-'0');
                turn = true;
            }
        }
        return sum;
    }
}