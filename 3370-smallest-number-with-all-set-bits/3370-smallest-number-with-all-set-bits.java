class Solution {
    public int smallestNumber(int n) {
         int temp = n;
         HashMap<Integer, Integer> map = new HashMap<>();
         while(true){
              String s = Integer.toBinaryString(temp);
              int val = Integer.parseInt(s);
              map.put(temp , Integer.bitCount(temp));

               // Agar binary mein saare bits set hain
            if (map.get(temp) == s.length()) {
                return temp;
            }
            temp++;
         }   
    }
}