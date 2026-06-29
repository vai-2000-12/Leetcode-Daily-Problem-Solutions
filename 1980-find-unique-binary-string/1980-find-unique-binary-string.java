import java.util.*;

class Solution {
    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;
        ArrayList<Integer> lst = new ArrayList<>();

        // Binary strings ko integer mein convert karo
        for (String num : nums) {
            int val = Integer.parseInt(num, 2);
            lst.add(val);
        }

        // 0 se 2^n - 1 tak check karo
        for (int i = 0; i < (1 << n); i++) {

            if (!lst.contains(i)) {

                String ans = Integer.toBinaryString(i);

                // Leading zeroes add karo
                while (ans.length() < n) {
                    ans = "0" + ans;
                }

                return ans;
            }
        }

        return "";
    }
}