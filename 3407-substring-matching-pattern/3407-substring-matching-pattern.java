class Solution {

    public boolean hasMatch(String s, String p) {

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

                String sub = s.substring(i, j + 1);

                if (match(sub, p))
                    return true;
            }
        }

        return false;
    }

    private boolean match(String str, String p) {

        int star = p.indexOf('*');

        // No '*'
        if (star == -1)
            return str.equals(p);

        String left = p.substring(0, star);
        String right = p.substring(star + 1);

        // Substring should at least contain left + right
        if (str.length() < left.length() + right.length())
            return false;

        // Prefix check
        if (!str.startsWith(left))
            return false;

        // Suffix check
        if (!str.endsWith(right))
            return false;

        return true;
    }
}