class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        int max = 0;
        for(int i = 0 ; i < n ; i++){
             max = Math.max(max , nums[i]);  
             int currEle = nums[i] + max;

             if(i == 0){
                ans[i]= currEle;
             }else{
             ans[i] = currEle + ans[i-1];
        }
    }
        return ans;
    }
}