class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
       List<Integer> ans = new ArrayList<>();
        String s = "123456789";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j++) {
                int num = Integer.parseInt(s.substring(i, j));

                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}