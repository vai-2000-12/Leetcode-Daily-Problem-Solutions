class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int val : nums){
            max = Math.max(max , val);
        }
        int minMoves =0;
        for(int val : nums){
            if(val < max){
                 int diff = max-val;
                 minMoves+=diff;
            }
        }
        return minMoves;
    }
}