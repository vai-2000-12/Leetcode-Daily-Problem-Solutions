class Solution {
    public int countSymmetricIntegers(int low, int high) {
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i = low ; i <= high ; i++){
            if(CheckIfDigitIsSame(i)){
                lst.add(i);
            }
        }   
        return lst.size();
    }
    public boolean CheckIfDigitIsSame(int num){
         String s = String.valueOf(num);

    if (s.length() % 2 != 0)
        return false;

    int mid = s.length() / 2;
    int first = 0;
    int second = 0;

    for (int i = 0; i < mid; i++) {
        first += s.charAt(i) - '0';
    }

    for (int i = mid; i < s.length(); i++) {
        second += s.charAt(i) - '0';
    }

    return first == second;
    }
}