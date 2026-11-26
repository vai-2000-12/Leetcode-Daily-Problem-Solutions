class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        ArrayList<int[]> lst = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int k = nums.size();

        for (int i = 0; i < k; i++) {
            List<Integer> num = nums.get(i);

            for (int val : num) {
                lst.add(new int[]{val, i});
            }
        }

        lst.sort((a, b) -> Integer.compare(a[0], b[0]));

        int left = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        for (int right = 0; right < lst.size(); right++) {

            int val = lst.get(right)[0];
            int id = lst.get(right)[1];

            map.put(id, map.getOrDefault(id, 0) + 1);

            while (map.size() == k) {

                int range = lst.get(right)[0] - lst.get(left)[0];

                if (range < min) {
                    min = range;
                    start = lst.get(left)[0];
                    end = lst.get(right)[0];
                }

                int leftId = lst.get(left)[1];

                map.put(leftId, map.get(leftId) - 1);

                if (map.get(leftId) == 0) {
                    map.remove(leftId);
                }

                left++;
            }
        }

        return new int[]{start, end};
    }
}