class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();

        while (nums.length > 0) {
            int[] arr = getDistinctNumArray(nums);

            Arrays.sort(arr);

            for (int num : arr) {
                result.add(num);
            }

            nums = removeDistinctNum(nums, arr);
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    public int[] getDistinctNumArray(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int[] ans = new int[set.size()];
        int indx = 0;

        for (int num : set) {
            ans[indx++] = num;
        }

        return ans;
    }

    public int[] removeDistinctNum(int[] nums, int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                list.add(num);
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}