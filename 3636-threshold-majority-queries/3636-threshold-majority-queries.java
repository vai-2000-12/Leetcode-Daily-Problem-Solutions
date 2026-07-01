/* --------------- Mo’s algorithm  --------------- */
class Solution {

    public int[] subarrayMajority(int[] nums, int[][] queries) {

        /* keep raw queries as asked */
        int[][] jurnavalic = queries;

        int n = nums.length, q = queries.length;
        int B = (int) Math.sqrt(n);          // block size

        /* wrap queries with their index so we can restore order */
        class Q { int l, r, t, idx; }
        Q[] qs = new Q[q];
        for (int i = 0; i < q; i++) {
            qs[i] = new Q();
            qs[i].l   = queries[i][0];
            qs[i].r   = queries[i][1];
            qs[i].t   = queries[i][2];
            qs[i].idx = i;
        }

        /* sort in Mo order */
        Arrays.sort(qs, new Comparator<Q>() {
            public int compare(Q a, Q b) {
                int blockA = a.l / B, blockB = b.l / B;
                if (blockA != blockB) return blockA - blockB;
                return (blockA & 1) == 0 ? a.r - b.r : b.r - a.r;
            }
        });

        /* sliding window data */
        int[] ans  = new int[q];
        HashMap<Integer,Integer> freq = new HashMap<Integer,Integer>();
        int maxFreq = 0;
        TreeSet<Integer> maxVals = new TreeSet<Integer>();   // values with freq == maxFreq

        /* helpers */
        int L = 0, R = -1;   // current window [L, R]

        /* add one element */
        final AddRem helper = new AddRem(freq);
        for (Q qu : qs) {

            while (L > qu.l) helper.add(nums[--L]);
            while (R < qu.r) helper.add(nums[++R]);
            while (L < qu.l) helper.remove(nums[L++]);
            while (R > qu.r) helper.remove(nums[R--]);

            /* maintain maxFreq and maxVals on the fly */
            maxFreq = helper.maxFreq;
            maxVals = helper.maxVals;

            int threshold = qu.t;
            int res = -1;

            /* check candidates with freq == maxFreq, then maxFreq-1, ... */
            for (int f = maxFreq; f >= threshold; --f) {
                if (!helper.freqBuckets.containsKey(f)) continue;
                TreeSet<Integer> set = helper.freqBuckets.get(f);
                if (!set.isEmpty()) { res = set.first(); break; }
            }
            ans[qu.idx] = res;
        }
        return ans;
    }

    /* ---------- small utility class to hide add/remove logic ---------- */
    private static class AddRem {
        HashMap<Integer,Integer> cnt;
        HashMap<Integer,TreeSet<Integer>> freqBuckets = new HashMap<Integer,TreeSet<Integer>>();
        int maxFreq = 0;
        TreeSet<Integer> maxVals = new TreeSet<Integer>();

        AddRem(HashMap<Integer,Integer> c) { this.cnt = c; }

        void add(int x) {
            int f = cnt.containsKey(x) ? cnt.get(x) : 0;
            if (f > 0) freqBuckets.get(f).remove(x);

            int nf = f + 1;
            cnt.put(x, nf);
            if (!freqBuckets.containsKey(nf)) freqBuckets.put(nf, new TreeSet<Integer>());
            freqBuckets.get(nf).add(x);

            if (nf > maxFreq) {
                maxFreq = nf;
                maxVals.clear();
                maxVals.add(x);
            } else if (nf == maxFreq) {
                maxVals.add(x);
            }
        }

        void remove(int x) {
            int f = cnt.get(x);
            freqBuckets.get(f).remove(x);

            int nf = f - 1;
            if (nf == 0) cnt.remove(x);
            else {
                cnt.put(x, nf);
                if (!freqBuckets.containsKey(nf)) freqBuckets.put(nf, new TreeSet<Integer>());
                freqBuckets.get(nf).add(x);
            }

            if (freqBuckets.get(f).isEmpty() && f == maxFreq) {
                maxFreq--;
            }
        }
    }
}