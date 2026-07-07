class Solution {
    public String majorityFrequencyGroup(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Frequency -> List of Characters
        HashMap<Integer, ArrayList<Character>> map1 = new HashMap<>();

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            char ch = e.getKey();
            int freq = e.getValue();

            map1.putIfAbsent(freq, new ArrayList<>());
            map1.get(freq).add(ch);
        }

        int maxSize = 0;
        int selectedFreq = 0;

        for (Map.Entry<Integer, ArrayList<Character>> e : map1.entrySet()) {
            int freq = e.getKey();
            int size = e.getValue().size();

            if (size > maxSize || (size == maxSize && freq > selectedFreq)) {
                maxSize = size;
                selectedFreq = freq;
            }
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : map1.get(selectedFreq)) {
            ans.append(ch);
        }

        return ans.toString();
    }
}