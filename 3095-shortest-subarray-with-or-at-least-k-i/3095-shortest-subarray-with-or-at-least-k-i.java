class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                int[]arr = Arrays.copyOfRange(nums, i , j+1);
                if(isSpecial(arr, k)){
                      minLen = Math.min(minLen , j-i+1);  
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen; 
    }
    public boolean isSpecial(int[] arr , int k){
     int or = 0;

    for (int num : arr) {
        or |= num;
    }

    return or >= k;
    }
}