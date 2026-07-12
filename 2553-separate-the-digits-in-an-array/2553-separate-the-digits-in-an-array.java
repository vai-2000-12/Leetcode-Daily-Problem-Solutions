class Solution {
    public int[] separateDigits(int[] nums) {
       int n = nums.length;
       ArrayList<Integer> lst = new ArrayList<>();
       for(int i = 0 ; i < n ; i++){
         String s = Integer.toString(nums[i]);
         lst.addAll(SeperateDigitFromEveryNum(s));
       }
       int[]ans = new int[lst.size()];
       for(int i = 0 ; i < lst.size() ; i++){
        ans[i] = lst.get(i);
       } 

       return ans;
    }
    public ArrayList<Integer> SeperateDigitFromEveryNum(String s){
         int n = Integer.parseInt(s);
        ArrayList<Integer> lst = new ArrayList<>();
         while( n != 0){
            int digit = n % 10;
            lst.add(0, digit);
            n/=10;
         }
         return lst;
    }
}