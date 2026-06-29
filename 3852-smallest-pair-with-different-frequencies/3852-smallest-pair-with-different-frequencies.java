class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        ArrayList<Integer> lst = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();
            lst.add(key);
        }

        if (lst.size() < 2) {
            return new int[]{-1, -1};
        }

        for (int i = 0; i < lst.size(); i++) {
            for (int j = i + 1; j < lst.size(); j++) {
                if (map.get(lst.get(i)).intValue() != map.get(lst.get(j)).intValue()) {
                    return new int[]{lst.get(i), lst.get(j)};
                }
            }
        }

        return new int[]{-1, -1};
    }
}