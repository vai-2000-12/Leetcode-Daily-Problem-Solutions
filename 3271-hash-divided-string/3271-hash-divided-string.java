class Solution {
    public String stringHash(String s, int k) {
       HashMap<Character, Integer> map = new HashMap<>();
       map.put('a', 0);   
       map.put('b', 1);   
       map.put('c', 2);   
       map.put('d', 3);   
       map.put('e', 4);   
       map.put('f', 5);   
       map.put('g', 6);   
       map.put('h', 7);   
       map.put('i', 8);   
       map.put('j', 9);   
       map.put('k', 10);   
       map.put('l', 11);   
       map.put('m', 12);   
       map.put('n', 13);   
       map.put('o', 14);   
       map.put('p', 15);   
       map.put('q', 16);   
       map.put('r', 17);   
       map.put('s', 18);   
       map.put('t', 19);   
       map.put('u', 20);   
       map.put('v', 21);   
       map.put('w', 22);   
       map.put('x', 23);   
       map.put('y', 24);   
       map.put('z', 25);   

        StringBuilder result = new StringBuilder();
        int n = s.length();
      

        for (int i = 0; i < n; i += k) {

            String sub = s.substring(i, i + k);
            int sum = 0;

            for (int j = 0; j < sub.length(); j++) {
                sum += map.get(sub.charAt(j));
            }

            int hashedChar = sum % 26;

            for (char ch : map.keySet()) {
                if (map.get(ch) == hashedChar) {
                    result.append(ch);
                    break;
                }
            }
        }

        return result.toString();
    }
}