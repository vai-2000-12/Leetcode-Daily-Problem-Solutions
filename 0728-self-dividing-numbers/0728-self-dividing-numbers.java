class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> myLst = getNumbersInRange(left, right);
        List<Integer> ans = new ArrayList<>();

        int n = myLst.size();
        for (int i = 0; i < n; i++) {
            if (isSelfDividing(myLst.get(i))) {
                ans.add(myLst.get(i));
            }
        }

        return ans;
    }

    public List<Integer> getNumbersInRange(int l, int r) {
        List<Integer> lst = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            lst.add(i);
        }

        return lst;
    }

    public boolean isSelfDividing(int n) {
        int temp = n;

        while (temp != 0) {
            int digit = temp % 10;

            if (digit == 0 || n % digit != 0) {
                return false;
            }

            temp /= 10;
        }

        return true;
    }
}