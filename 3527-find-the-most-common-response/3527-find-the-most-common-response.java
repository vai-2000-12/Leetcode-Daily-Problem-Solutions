class Solution {
    public String findCommonResponse(List<List<String>> responses) {

        HashMap<String, Integer> map = new HashMap<>();

        for (List<String> list : responses) {

            HashSet<String> set = new HashSet<>(list);

            for (String word : set) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        int maxFreq = 0;
        String ans = "";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                ans = entry.getKey();
            }
            else if (entry.getValue() == maxFreq &&
                     entry.getKey().compareTo(ans) < 0) {
                ans = entry.getKey();  
            }
        }

        return ans;
    }
}