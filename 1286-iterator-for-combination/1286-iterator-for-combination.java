import java.util.ArrayList;
import java.util.Iterator;

class CombinationIterator {

    private ArrayList<String> list = new ArrayList<>();
    private Iterator<String> it;

    public CombinationIterator(String characters, int combinationLength) {

        generate(characters, combinationLength, 0, "");

        it = list.iterator();
    }

    private void generate(String str, int k, int index, String curr) {

        // Base Case
        if (curr.length() == k) {
            list.add(curr);
            return;
        }

        // Out of Bound
        if (index == str.length()) {
            return;
        }

        // Include current character
        generate(str, k, index + 1, curr + str.charAt(index));

        // Exclude current character
        generate(str, k, index + 1, curr);
    }

    public String next() {
        return it.next();
    }

    public boolean hasNext() {
        return it.hasNext();
    }
}