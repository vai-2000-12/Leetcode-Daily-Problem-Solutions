class SmallestInfiniteSet {
    HashSet<Integer> set;
    Stack<Integer> st;
    int curr;

    public SmallestInfiniteSet() {
        set = new HashSet<>();
        st = new Stack<>();
        curr = 1;
    }

    public int popSmallest() {
        if (!set.isEmpty()) {
            int min = Collections.min(set);
            set.remove(min);
            return min;
        }

        return curr++;
    }

    public void addBack(int num) {
        if (num < curr && !set.contains(num)) {
            set.add(num);
        }
    }
}