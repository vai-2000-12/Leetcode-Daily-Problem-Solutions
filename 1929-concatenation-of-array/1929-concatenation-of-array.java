import java.util.*;

class Solution {
    public int[] getConcatenation(int[] nums) {

        int[] temp = nums.clone();

        ArrayList<Integer> lst = new ArrayList<>();

        // First array add
        for (int x : nums) {
            lst.add(x);
        }

        // Second array add
        for (int x : temp) {
            lst.add(x);
        }

        // Convert ArrayList back to int[]
        int[] ans = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            ans[i] = lst.get(i);
        }

        return ans;
    }
}