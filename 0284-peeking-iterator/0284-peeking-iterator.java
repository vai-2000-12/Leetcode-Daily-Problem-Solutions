class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> itr;
    Integer temp;

    public PeekingIterator(Iterator<Integer> iterator) {
        itr = iterator;

        if (itr.hasNext()) {
            temp = itr.next();
        }
    }

    public Integer peek() {
        return temp;
    }

    @Override
    public Integer next() {

        Integer ans = temp;

        if (itr.hasNext()) {
            temp = itr.next();
        } else {
            temp = null;
        }

        return ans;
    }

    @Override
    public boolean hasNext() {
        return temp != null;
    }
}