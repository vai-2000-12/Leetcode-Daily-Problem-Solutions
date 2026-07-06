class Solution {
    public int smallestNumber(int n, int t) {
            while (true) {
            int product = getDigitProd(n);

            if (product % t == 0) {
                return n;
            }

            n++;
            }
    }
    public int getDigitProd(int n){
         if (n == 0) return 0;

       int prod = 1;
       while(n !=0){
           int digit = n % 10;
           prod *= digit;
           n/=10; 
       }
       return prod;
    }
}