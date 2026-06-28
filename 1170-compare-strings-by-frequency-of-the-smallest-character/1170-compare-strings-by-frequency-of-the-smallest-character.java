import java.util.*;

class Solution {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int n = queries.length;
        int m = words.length;

        int[] wordFreq = new int[m];

        // step 1: compute f(word) for all words
        for (int i = 0; i < m; i++) {
            wordFreq[i] = getFreq(words[i]);
        }

        // step 2: sort word frequencies
        Arrays.sort(wordFreq);

        int[] ans = new int[n];

        // step 3: for each query use binary search
        for (int i = 0; i < n; i++) {

            int qFreq = getFreq(queries[i]);

            int idx = upperBound(wordFreq, qFreq);

            ans[i] = m - idx; // elements > qFreq
        }

        return ans;
    }

    // O(n)
    public int getFreq(String s) {

        char smallest = 'z';
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c < smallest) {
                smallest = c;
                count = 1;
            } else if (c == smallest) {
                count++;
            }
        }

        return count;
    }

    // first index where value > target
    public int upperBound(int[] arr, int target) {

        int l = 0, r = arr.length;

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}