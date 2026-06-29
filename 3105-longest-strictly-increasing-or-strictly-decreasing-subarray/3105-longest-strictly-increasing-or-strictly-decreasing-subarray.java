class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                int[] sub = Arrays.copyOfRange(nums, i , j+1);

                if(isInc(sub) || isDec(sub)){
                    maxLen = Math.max(maxLen , j-i+1);
                }
            }
        }
        return maxLen;
    }
   
    public boolean isInc(int[] arr){
          for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
    public boolean isDec(int[]arr){
           for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}