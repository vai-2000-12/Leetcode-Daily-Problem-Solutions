import java.util.*;

class Solution {
    public int firstUniqueFreq(int[] nums) {
        // Frequency of elements
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0 ; i < n ; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Store frequencies
        ArrayList<Integer> lst = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int val = e.getValue();
            lst.add(val);
        }

        // Frequency of frequencies
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0 ; i < lst.size() ; i++) {
            map2.put(lst.get(i), map2.getOrDefault(lst.get(i), 0) + 1);
        }   

        // return array element, not frequency
        for (int i = 0 ; i < n ; i++) {
            int freq = map.get(nums[i]);

            if (map2.get(freq) == 1) {
                return nums[i];
            }
        }

        return -1;
    }
}