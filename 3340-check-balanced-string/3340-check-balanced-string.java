class Solution {
    public boolean isBalanced(String num) {
        int evenSum = 0; 
        int oddSum = 0;  

        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0'; // Convert char to int

            if (i % 2 == 0) { // Even position
                evenSum += digit;
            } else {          // Odd position
                oddSum += digit;
            }
        }

        return evenSum == oddSum; // Check if the sums are equal
    }
}