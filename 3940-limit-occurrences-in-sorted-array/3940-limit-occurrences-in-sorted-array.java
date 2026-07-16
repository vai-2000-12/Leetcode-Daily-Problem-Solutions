class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
     HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums) {
            int freq = map.getOrDefault(num, 0);

            if (freq < k) {
                list.add(num);
                map.put(num, freq + 1);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}