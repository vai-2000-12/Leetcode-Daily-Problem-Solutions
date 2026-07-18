class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int smallest = nums[0];
        int largest = nums[nums.length-1];

        int ans = GCD(smallest , largest);
        return ans;
    }

    public int GCD(int a , int b){
         if(b == 0){
            return a;
         }

         return GCD(b , a%b);
    }
}