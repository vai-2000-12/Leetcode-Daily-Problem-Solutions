class Solution {
    public int mirrorFrequency(String s) {
        HashMap<Character, Character> map1 = new HashMap();
        map1.put('a' , 'z');
        map1.put('b' , 'y');
        map1.put('c' , 'x');
        map1.put('d' , 'w');
        map1.put('e' , 'v');
        map1.put('f' , 'u');
        map1.put('g' , 't');
        map1.put('h' , 's');
        map1.put('i' , 'r');
        map1.put('j' , 'q');
        map1.put('k' , 'p');
        map1.put('l' , 'o');
        map1.put('m' , 'n');
        map1.put('n' , 'm');
        map1.put('o' , 'l');
        map1.put('p' , 'k');
        map1.put('q' , 'j');
        map1.put('r' , 'i');
        map1.put('s' , 'h');
        map1.put('t' , 'g');
        map1.put('u' , 'f');
        map1.put('v' , 'e');
        map1.put('w' , 'd');
        map1.put('x' , 'c');
        map1.put('y' , 'b');
        map1.put('z' , 'a');

        HashMap<Character, Character> map2 = new HashMap<>();
        map2.put('0', '9');
        map2.put('1', '8');
        map2.put('2', '7');
        map2.put('3', '6');
        map2.put('4', '5');
        map2.put('5', '4');
        map2.put('6', '3');
        map2.put('7', '2');
        map2.put('8', '1');
        map2.put('9', '0');

          // Frequency Map
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        HashSet<Character> visited = new HashSet<>();
        int ans = 0;

        for (char ch : freq.keySet()) {

            if (visited.contains(ch))
                continue;

            char mirror;

            if (Character.isLetter(ch))
                mirror = map1.get(ch);
            else
                mirror = map2.get(ch);

            int f1 = freq.getOrDefault(ch, 0);
            int f2 = freq.getOrDefault(mirror, 0);

            ans += Math.abs(f1 - f2);

            visited.add(ch);
            visited.add(mirror);
        }

        return ans;
    }
}