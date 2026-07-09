class Solution {
    public int minIncrementForUnique(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        Queue<Integer> missing = new LinkedList<>();

        for (int i = min; i <= max; i++) {
            if (!freq.containsKey(i))
                missing.offer(i);
        }

        int ans = 0;
        int next = max + 1;

        for (int i = min; i <= max; i++) {

            if (!freq.containsKey(i))
                continue;

            int f = freq.get(i);

            while (f > 1) {

                // Remove missing numbers smaller than current value
                while (!missing.isEmpty() && missing.peek() < i)
                    missing.poll();

                if (!missing.isEmpty()) {
                    int val = missing.poll();
                    ans += val - i;
                } else {
                    ans += next - i;
                    next++;
                }

                f--;
            }
        }

        return ans;
    }
}