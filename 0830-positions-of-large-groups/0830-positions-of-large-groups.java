class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
            List<List<Integer>> ans = new ArrayList<>();
        int n = s.length();
        int i = 0;

        while (i < n) {

            int start = i;

            while (i < n && s.charAt(i) == s.charAt(start)) {
                i++;
            }

            int end = i - 1;

            if (end - start + 1 >= 3) {
                ans.add(Arrays.asList(start, end));
            }
        }

        return ans;            
    }
}